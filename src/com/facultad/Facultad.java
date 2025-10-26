package com.facultad;

import javax.persistence.*;

public class Facultad {
     private Integer id;
    private String nombre;
    private Ciudad ciudad;

    public Facultad() {
    }
    
    public Facultad(String nombre, Ciudad ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
   
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
  
    @Override
    public String toString() {
        return "Facultad{" + "id=" + id  + "nombre=" + nombre + ", ciudad=" + ciudad + '}';
    }
    
    
}
