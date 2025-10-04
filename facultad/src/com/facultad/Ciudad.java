
package com.facultad;

public class Ciudad {
    
    private String nombre;

    public Ciudad() {
    }
    
    public Ciudad(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return "Ciudad{" + "nombre=" + nombre + '}';
    }
}
