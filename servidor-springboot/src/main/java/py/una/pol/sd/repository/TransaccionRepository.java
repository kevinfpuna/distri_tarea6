package py.una.pol.sd.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import py.una.pol.sd.model.Transaccion;

@Repository
public interface TransaccionRepository extends CrudRepository<Transaccion, Integer> {

    List<Transaccion> findAll();

    List<Transaccion> findByFecha(LocalDate fecha);

    List<Transaccion> findByClienteId(Integer clienteId);

    List<Transaccion> findByDescripcion(String descripcion);
}