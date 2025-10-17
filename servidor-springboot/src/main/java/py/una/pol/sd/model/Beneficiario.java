package py.una.pol.sd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "beneficiarios")
public class Beneficiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nombre;
    private String cuenta;

    protected Beneficiario() {}

    public Beneficiario(String nombre, String cuenta) {
        this.nombre = nombre;
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return String.format(
            "Beneficiario[id=%d, nombre='%s', cuenta='%s']",
            id, nombre, cuenta);
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }
}