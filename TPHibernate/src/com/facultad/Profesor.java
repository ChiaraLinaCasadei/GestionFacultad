package com.facultad;

import java.time.LocalDate;
import javax.persistence.*;

public class Profesor extends Persona {
    private int antiguedad;

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Profesor(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Profesor(int antiguedad, Integer id, String apellido, String nombre, String dni, LocalDate fechaNacimiento, Ciudad ciudad) {
        super(id,apellido, nombre, dni, fechaNacimiento, ciudad);
        this.antiguedad = antiguedad;
    }
    
    @Override
    public String toString() {
        return "Profesor{" + "antiguedad=" + antiguedad + '}';
    }
    
    
}
