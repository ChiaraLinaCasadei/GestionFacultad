package com.facultad;

import java.util.ArrayList;
import javax.persistence.*;

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<Materia> materias) {
        this.materias = materias;
    }
    
    

    @Override
    public String toString() {
        return "Carrera{" + "nombre=" + nombre + ", facultad=" + facultad + ", materias=" + materias + '}';
    }
    
    
}
