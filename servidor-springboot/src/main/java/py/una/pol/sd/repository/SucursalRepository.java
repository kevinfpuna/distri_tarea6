package py.una.pol.sd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import py.una.pol.sd.model.Sucursal;

@Repository
public interface SucursalRepository extends CrudRepository<Sucursal, Integer> {

    List<Sucursal> findAll();

    List<Sucursal> findByNombre(String nombre);

    List<Sucursal> findByCiudad(String ciudad);
}