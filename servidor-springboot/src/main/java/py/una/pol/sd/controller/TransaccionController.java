package py.una.pol.sd.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import py.una.pol.sd.model.Transaccion;
import py.una.pol.sd.service.TransaccionService;

@RestController
@RequestMapping("/transacciones")
public class TransaccionController {

    @Autowired
    TransaccionService transaccionService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> porFecha(@RequestParam(name = "fecha", required = true) String fechaStr) {
        try {
            LocalDate fecha = LocalDate.parse(fechaStr);
            List<Transaccion> transacciones = transaccionService.porFecha(fecha);
            return new ResponseEntity<>(transacciones, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Fecha inválida, use formato YYYY-MM-DD", HttpStatus.BAD_REQUEST);
        }
    }
}