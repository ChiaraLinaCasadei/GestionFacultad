package com.facultad;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private Integer id;
    private String nombre;
    private String nivel;
    private Profesor profesor;
    private List<Alumno> alumnos = new ArrayList<Alumno>();

    public Materia() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Materia(Integer id,String nombre, String nivel, Profesor profesor, List<Alumno> alumnos) {
        this.id = id;
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
