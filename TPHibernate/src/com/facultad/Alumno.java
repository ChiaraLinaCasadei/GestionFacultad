package com.facultad;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

public class Alumno extends Persona implements Serializable {
   
    private int numeroLegajo;
    private int anioIngreso; 

    public int getNumeroLegajo() {
        return numeroLegajo;
    }

    public void setNumeroLegajo(int numeroLegajo) {
        this.numeroLegajo = numeroLegajo;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnioIngreso(int anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

    public Alumno() {
    }
    
    public Alumno(int numeroLegajo, int anioIngreso) {
        this.numeroLegajo = numeroLegajo;
        this.anioIngreso = anioIngreso;
    }

    public Alumno(int numeroLegajo, int anioIngreso,Integer id, String apellido, String nombre, String dni, LocalDate fechaNacimiento, Ciudad ciudad) {
        super(id,apellido, nombre, dni, fechaNacimiento, ciudad);
        this.numeroLegajo = numeroLegajo;
        this.anioIngreso = anioIngreso;
    }
    
    @Override
    public String toString() {
        return "Alumno{" + "numeroLegajo=" + numeroLegajo + ", anioIngreso=" + anioIngreso + '}';
    }
    
}
