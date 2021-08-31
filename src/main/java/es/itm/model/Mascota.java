package es.itm.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="mascotas")
public class Mascota implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_mascota;
    @Column(length=30, nullable=false)
    private String nombre;
    @ManyToOne(optional=false)
    @JoinColumn(name="tipo", referencedColumnName="id_tipo")
    private Tipo tipo;
    @Column(columnDefinition="DECIMAL(6,2)", nullable=false)
    private double precio;
    @ManyToOne(optional=true)
    @JoinColumn(name="id_venta", referencedColumnName="id_venta")
    private Venta venta;

    public Mascota() {
    }

    public Mascota(int id_mascota, String nombre, Tipo tipo, double precio, Venta venta) {
        this.id_mascota = id_mascota;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.venta = venta;
    }

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
}
