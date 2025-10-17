package py.una.pol.sd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sucursales")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nombre;
    private String ciudad;

    protected Sucursal() {}

    public Sucursal(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return String.format(
            "Sucursal[id=%d, nombre='%s', ciudad='%s']",
            id, nombre, ciudad);
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}