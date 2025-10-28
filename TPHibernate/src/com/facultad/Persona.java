package com.facultad;

import java.util.Date;
import javax.persistence.*;

public class Persona {

    private Integer id;
    private String apellido;
    private String nombre;
    private String dni;
    private Date fechaNacimiento;
    private Ciudad ciudad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Persona() {
    }

    public Persona(Integer id, String apellido, String nombre, String dni, Date fechaNacimiento, Ciudad ciudad) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Persona{" + "apellido=" + apellido + ", nombre=" + nombre + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + ", ciudad=" + ciudad + '}';
    }
}