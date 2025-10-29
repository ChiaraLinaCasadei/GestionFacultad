package com.facultad;

import java.util.Date;

public class Profesor extends Persona {
    private int antiguedad;

    public Profesor() {
        super();
    }
    
    public Profesor(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Profesor(int antiguedad, Integer id, String apellido, String nombre, String dni, Date fechaNacimiento, Ciudad ciudad) {
        super(id, apellido, nombre, dni, fechaNacimiento, ciudad);
        this.antiguedad = antiguedad;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    
    @Override
    public String toString() {
        return "Profesor{"
                + "id=" + getId()
                + ", nombre='" + getNombre() + '\''
                + ", apellido='" + getApellido() + '\''
                + ", antiguedad=" + antiguedad
                + '}';
    }

}
