package es.itm.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipos")
public class Tipo implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_tipo;
    @Column(length=30, nullable=false)
    private String nombre;

    public Tipo() {
    }

    public Tipo(int id_tipo, String nombre) {
        this.id_tipo = id_tipo;
        this.nombre = nombre;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
