package py.una.pol.sd.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.una.pol.sd.model.Transferencia;
import py.una.pol.sd.repository.TransferenciaRepository;

@Service
public class TransferenciaService {

    @Autowired
    TransferenciaRepository repository;

    @Transactional
    public Transferencia crear(Transferencia transferencia) {
        if (transferencia.getFecha() == null) {
            transferencia.setFecha(LocalDateTime.now());
        }
        return repository.save(transferencia);
    }
}