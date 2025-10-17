package py.una.pol.sd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import py.una.pol.sd.model.Transferencia;

@Repository
public interface TransferenciaRepository extends CrudRepository<Transferencia, Integer> {

    List<Transferencia> findAll();

    List<Transferencia> findByOrigenCuenta(String origenCuenta);

    List<Transferencia> findByDestinoCuenta(String destinoCuenta);
}