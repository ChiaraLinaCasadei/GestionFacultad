package com.facultad;

import java.util.ArrayList;
import java.util.List;

public class Carrera {

    private Integer id;
    private String nombre;
    private Facultad facultad;
    private List<Materia> materias = new ArrayList<>();

    public Carrera() {
    }

    public Carrera(Integer id, String nombre, Facultad facultad, List<Materia> materias) {
        this.id = id;
        this.nombre = nombre;
        this.facultad = facultad;
        this.materias = materias;
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

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    @Override
    public String toString() {
        return "Carrera{" + "nombre=" + nombre + ", facultad=" + facultad + ", materias=" + materias + '}';
    }

}
