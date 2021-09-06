package es.itm.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @Column(nullable=false, unique=true, columnDefinition="CHAR(9)")
    private String dni;
    @Column(length=30, nullable=false)
    private String nombre;
    @Column(length=30, nullable=false)
    private String apellidos;
    @Column(length=50, nullable=false)
    private String direccion;
    @Column(length=50, nullable=false)
    private String localidad;
    @Column(length=50, nullable=false)
    private String correo;
    @Column(columnDefinition="CHAR(9)", nullable=false)
    private String telefono;

    public Cliente() {
    }

    public Cliente(String dni, String nombre, String apellidos, String direccion, String localidad, String correo, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.localidad = localidad;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
