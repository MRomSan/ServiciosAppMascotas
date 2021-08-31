package es.itm.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ventas")
public class Venta implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @Column(nullable=false, unique=true, columnDefinition="CHAR(8)")
    private String id_venta;
    @ManyToOne(optional=false)
    @JoinColumn(name="id_usuario", referencedColumnName="id_usuario")
    private Usuario empleado;
    @ManyToOne(optional=false)
    @JoinColumn(name="dni_cliente", referencedColumnName="dni")
    private Cliente cliente;
    @Column(columnDefinition="DATETIME", nullable=false)
    private String fecha;

    public Venta() {
    }

    public Venta(Usuario empleado, Cliente cliente, String fecha) {
        this.empleado = empleado;
        this.cliente = cliente;
        this.fecha = fecha;
    }

    public String getId_venta() {
        return id_venta;
    }

    public void setId_venta(String id_venta) {
        this.id_venta = id_venta;
    }

    public Usuario getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Usuario empleado) {
        this.empleado = empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
