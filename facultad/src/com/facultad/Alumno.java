package com.facultad;

import java.time.LocalDate;

public class Alumno extends Persona {
   
    private String numeroLegajo;
    private int anioIngreso; 

    public Alumno() {
    }
    
    public Alumno(
            String apellido,
            String nombre,
            String dni,
            LocalDate fechaNacimiento,
            Ciudad ciudad,
            String numeroLegajo,
            int anioIngreso)
    {
        this.setApellido(apellido);
        this.setNombre(nombre);
        this.setDni(dni);
        this.setFechaNacimiento(fechaNacimiento);
        this.setCiudad(ciudad);
        this.numeroLegajo = numeroLegajo;
        this.anioIngreso = anioIngreso;
    }

    @Override
    public String toString() {
        return "Alumno{" + "numeroLegajo=" + numeroLegajo + ", anioIngreso=" + anioIngreso + '}';
    }
    
}
