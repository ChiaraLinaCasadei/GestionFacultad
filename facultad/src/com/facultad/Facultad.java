package com.facultad;

public class Facultad {
    private String nombre;
    private Ciudad ciudad;

    public Facultad() {
    }
    
    public Facultad(String nombre, Ciudad ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Facultad{" + "nombre=" + nombre + ", ciudad=" + ciudad + '}';
    }
    
    
}
