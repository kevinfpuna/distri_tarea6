package py.una.pol.sd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.una.pol.sd.model.Transferencia;
import py.una.pol.sd.service.TransferenciaService;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    @Autowired
    TransferenciaService transferenciaService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> crear(@RequestHeader(value = "X-Token", required = false) String token,
                                   @RequestBody Transferencia transferencia) {
        
        if (token == null || !token.equals("abc123")) {
            return new ResponseEntity<>("Token inválido o faltante", HttpStatus.UNAUTHORIZED);
        }

        if (transferencia.getOrigenCuenta() == null || transferencia.getDestinoCuenta() == null || transferencia.getMonto() == null) {
            return new ResponseEntity<>("Campos requeridos: origen_cuenta, destino_cuenta, monto", HttpStatus.BAD_REQUEST);
        }

        if (transferencia.getMonto().signum() <= 0) {
            return new ResponseEntity<>("El monto debe ser mayor a 0", HttpStatus.BAD_REQUEST);
        }

        try {
            Transferencia resultado = transferenciaService.crear(transferencia);
            return new ResponseEntity<>(resultado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear transferencia: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}