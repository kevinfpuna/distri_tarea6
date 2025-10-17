package py.una.pol.sd.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.una.pol.sd.model.Beneficiario;
import py.una.pol.sd.repository.BeneficiarioRepository;

@Service
public class BeneficiarioService {

    @Autowired
    BeneficiarioRepository repository;

    public Optional<Beneficiario> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    @Transactional
    public Beneficiario crear(Beneficiario beneficiario) {
        return repository.save(beneficiario);
    }

    @Transactional
    public void eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Beneficiario con ID " + id + " no existe");
        }
    }
}