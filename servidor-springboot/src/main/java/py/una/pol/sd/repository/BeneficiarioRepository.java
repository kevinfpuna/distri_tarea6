package py.una.pol.sd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import py.una.pol.sd.model.Beneficiario;

@Repository
public interface BeneficiarioRepository extends CrudRepository<Beneficiario, Integer> {

    List<Beneficiario> findAll();

    List<Beneficiario> findByNombre(String nombre);

    List<Beneficiario> findByCuenta(String cuenta);
}