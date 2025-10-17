package py.una.pol.sd.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.una.pol.sd.model.Cliente;
import py.una.pol.sd.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    public Optional<Cliente> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    @Transactional
    public Cliente actualizar(Integer id, Cliente datos) {
        datos.setId(id);
        return repository.save(datos);
    }
}