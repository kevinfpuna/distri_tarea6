package py.una.pol.sd.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transacciones")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "cliente_id")
    private Integer clienteId;
    
    private LocalDate fecha;
    private String descripcion;
    private BigDecimal monto;

    protected Transaccion() {}

    public Transaccion(Integer clienteId, LocalDate fecha, String descripcion, BigDecimal monto) {
        this.clienteId = clienteId;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.monto = monto;
    }

    @Override
    public String toString() {
        return String.format(
            "Transaccion[id=%d, clienteId=%d, fecha='%s', descripcion='%s', monto=%s]",
            id, clienteId, fecha, descripcion, monto);
    }

    public Integer getId() {
        return id;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
}