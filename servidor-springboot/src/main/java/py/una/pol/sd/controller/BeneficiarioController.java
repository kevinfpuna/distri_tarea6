package py.una.pol.sd.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.una.pol.sd.model.Beneficiario;
import py.una.pol.sd.service.BeneficiarioService;

@RestController
@RequestMapping("/beneficiarios")
public class BeneficiarioController {

    @Autowired
    BeneficiarioService beneficiarioService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtener(@PathVariable Integer id) {
        try {
            Optional<Beneficiario> beneficiario = beneficiarioService.obtenerPorId(id);
            if (beneficiario.isPresent()) {
                return new ResponseEntity<>(beneficiario.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Beneficiario no encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener beneficiario: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> crear(@RequestHeader(value = "X-Token", required = false) String token, 
                                   @RequestBody Beneficiario beneficiario) {
        
        if (token == null || !token.equals("abc123")) {
            return new ResponseEntity<>("Token inválido o faltante", HttpStatus.UNAUTHORIZED);
        }

        if (beneficiario != null && beneficiario.getNombre() != null && beneficiario.getCuenta() != null) {
            try {
                Beneficiario resultado = beneficiarioService.crear(beneficiario);
                return new ResponseEntity<>(resultado, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>("Error al crear beneficiario: " + e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Debe enviar los campos nombre y cuenta", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id, 
                                      @RequestHeader(value = "X-Token", required = false) String token) {
        
        if (token == null || !token.equals("abc123")) {
            return new ResponseEntity<>("Token inválido o faltante", HttpStatus.UNAUTHORIZED);
        }

        try {
            beneficiarioService.eliminar(id);
            return new ResponseEntity<>("Beneficiario eliminado correctamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar beneficiario: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}