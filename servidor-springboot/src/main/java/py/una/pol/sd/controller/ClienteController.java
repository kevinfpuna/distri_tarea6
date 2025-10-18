package py.una.pol.sd.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.una.pol.sd.model.Cliente;
import py.una.pol.sd.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtener(@PathVariable Integer id) {
        try {
            Optional<Cliente> cliente = clienteService.obtenerPorId(id);
            if (cliente.isPresent()) {
                return new ResponseEntity<>(cliente.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Cliente no encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener cliente: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> actualizar(@PathVariable Integer id,
                                        @RequestHeader(value = "X-Token", required = false) String token,
                                        @RequestBody Cliente datos) {
        
        if (token == null || !token.equals("abc123")) {
            return new ResponseEntity<>("Token inválido o faltante", HttpStatus.UNAUTHORIZED);
        }

        if (datos.getId() != null && !datos.getId().equals(id)) {
            return new ResponseEntity<>("ID del body no coincide con el path", HttpStatus.BAD_REQUEST);
        }

        try {
            Cliente resultado = clienteService.actualizar(id, datos);
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar cliente: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}