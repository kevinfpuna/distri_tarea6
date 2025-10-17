package py.una.pol.sd.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.una.pol.sd.model.Transaccion;
import py.una.pol.sd.repository.TransaccionRepository;

@Service
public class TransaccionService {

    @Autowired
    TransaccionRepository repository;

    public List<Transaccion> porFecha(LocalDate fecha) {
        return repository.findByFecha(fecha);
    }
}