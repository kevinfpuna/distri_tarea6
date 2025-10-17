package py.una.pol.sd.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transferencias")
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "origen_cuenta")
    private String origenCuenta;
    
    @Column(name = "destino_cuenta")
    private String destinoCuenta;
    
    private BigDecimal monto;
    private LocalDateTime fecha;

    protected Transferencia() {}

    public Transferencia(String origenCuenta, String destinoCuenta, BigDecimal monto) {
        this.origenCuenta = origenCuenta;
        this.destinoCuenta = destinoCuenta;
        this.monto = monto;
        this.fecha = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format(
            "Transferencia[id=%d, origenCuenta='%s', destinoCuenta='%s', monto=%s, fecha='%s']",
            id, origenCuenta, destinoCuenta, monto, fecha);
    }

    public Integer getId() {
        return id;
    }

    public String getOrigenCuenta() {
        return origenCuenta;
    }

    public String getDestinoCuenta() {
        return destinoCuenta;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOrigenCuenta(String origenCuenta) {
        this.origenCuenta = origenCuenta;
    }

    public void setDestinoCuenta(String destinoCuenta) {
        this.destinoCuenta = destinoCuenta;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}