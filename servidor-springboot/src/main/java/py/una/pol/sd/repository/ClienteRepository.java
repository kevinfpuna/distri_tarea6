package py.una.pol.sd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import py.una.pol.sd.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

    List<Cliente> findAll();

    List<Cliente> findByNombre(String nombre);

    List<Cliente> findByDireccion(String direccion);

    List<Cliente> findByTelefono(String telefono);
}