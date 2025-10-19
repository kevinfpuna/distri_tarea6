package py.una.pol.sd.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.una.pol.sd.model.Transferencia;
import py.una.pol.sd.repository.TransferenciaRepository;
import py.una.pol.sd.service.BeneficiarioService;

@Service
public class TransferenciaService {

    @Autowired
    TransferenciaRepository repository;

    @Autowired
    BeneficiarioService beneficiarioService;

    @Transactional
    public Transferencia crear(Transferencia transferencia) {
        if (!beneficiarioService.existeCuenta(transferencia.getOrigenCuenta())) {
            throw new RuntimeException("La cuenta de origen '" + transferencia.getOrigenCuenta() + "' no existe en el sistema");
        }
        
        if (!beneficiarioService.existeCuenta(transferencia.getDestinoCuenta())) {
            throw new RuntimeException("La cuenta de destino '" + transferencia.getDestinoCuenta() + "' no existe en el sistema");
        }
        
        if (transferencia.getFecha() == null) {
            transferencia.setFecha(LocalDateTime.now());
        }
        return repository.save(transferencia);
    }
}