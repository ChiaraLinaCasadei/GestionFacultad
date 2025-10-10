package com.facultad;

import java.util.ArrayList;

public class Carrera {
    private String nombre;
    private Facultad facultad;
    private ArrayList<Materia> materias;
    
    public Carrera() {
    }
    
    public Carrera(String nombre, Facultad facultad, ArrayList<Materia> materias) {
        this.nombre = nombre;
        this.facultad = facultad;
        this.materias = materias;
    }

    @Override
    public String toString() {
        return "Carrera{" + "nombre=" + nombre + ", facultad=" + facultad + ", materias=" + materias + '}';
    }
    
    
}
