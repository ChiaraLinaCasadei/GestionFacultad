package com.facultad;

import java.time.LocalDate;
import javax.persistence.*;

public class Alumno extends Persona {
   
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

    public Alumno(int numeroLegajo, int anioIngreso) {
        this.numeroLegajo = numeroLegajo;
        this.anioIngreso = anioIngreso;
    }

    public Alumno(int numeroLegajo, int anioIngreso, String apellido, String nombre, String dni, LocalDate fechaNacimiento, Ciudad ciudad) {
        super(apellido, nombre, dni, fechaNacimiento, ciudad);
        this.numeroLegajo = numeroLegajo;
        this.anioIngreso = anioIngreso;
    }
    
    @Override
    public String toString() {
        return "Alumno{" + "numeroLegajo=" + numeroLegajo + ", anioIngreso=" + anioIngreso + '}';
    }
    
}
