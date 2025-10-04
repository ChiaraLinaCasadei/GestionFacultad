package com.facultad;

import java.util.ArrayList;

public class Materia {
    private String nombre;
    private String nivel;
    private Profesor profesor;
    private ArrayList<Alumno> alumnos;

    public Materia() {
    }
    
    public Materia(String nombre, String nivel, Profesor profesor, ArrayList<Alumno> alumnos) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.profesor = profesor;
        this.alumnos = alumnos;
    }

    @Override
    public String toString() {
        return "Materia{" + "nombre=" + nombre + ", nivel=" + nivel + ", profesor=" + profesor + ", alumnos=" + alumnos + '}';
    }
    
    
}
