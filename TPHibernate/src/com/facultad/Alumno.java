package com.facultad;

import java.io.Serializable;
import java.util.Date;

public class Alumno extends Persona implements Serializable {

    private int numeroLegajo;
    private int anioIngreso;

    public Alumno(int numeroLegajo, int anioIngreso) {
        this.numeroLegajo = numeroLegajo;
        this.anioIngreso = anioIngreso;
    }

    public Alumno(int numeroLegajo, int anioIngreso, Integer id, String apellido, String nombre, String dni, Date fechaNacimiento, Ciudad ciudad) {
        super(id, apellido, nombre, dni, fechaNacimiento, ciudad);
        this.numeroLegajo = numeroLegajo;
        this.anioIngreso = anioIngreso;
    }

    public Alumno() {
        super();
    }

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

    @Override
    public String toString() {
        return "Alumno{"
                + "id=" + getId()
                + ", nombre='" + getNombre() + '\''
                + ", apellido='" + getApellido() + '\''
                + ", numeroLegajo=" + numeroLegajo
                + ", anioIngreso=" + anioIngreso
                + '}';
    }

}
