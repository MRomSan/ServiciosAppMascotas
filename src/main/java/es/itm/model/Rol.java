package es.itm.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol implements Serializable {
    @Id
    @Column(nullable=false, unique=true)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERol nombre;

    public Rol() {
    }

    public Rol(ERol nombre) {
        this.nombre = nombre;
    }
    
    public Rol(String nombre) {
        this.nombre = ERol.valueOf(nombre);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ERol getNombre() {
        return nombre;
    }

    public void setNombre(ERol nombre) {
        this.nombre = nombre;
    }
}
