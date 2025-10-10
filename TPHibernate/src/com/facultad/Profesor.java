package com.facultad;

import java.time.LocalDate;

public class Profesor extends Persona {
    private int antiguedad;

    public Profesor() {
    }
    
    public Profesor(
            String apellido,
            String nombre,
            String dni,
            LocalDate fechaNacimiento,
            Ciudad ciudad,
            int antiguedad)
    {
        this.setApellido(apellido);
        this.setNombre(nombre);
        this.setDni(dni);
        this.setFechaNacimiento(fechaNacimiento);
        this.setCiudad(ciudad);
        this.antiguedad = antiguedad;
    }

    @Override
    public String toString() {
        return "Profesor{" + "antiguedad=" + antiguedad + '}';
    }
    
    
}
