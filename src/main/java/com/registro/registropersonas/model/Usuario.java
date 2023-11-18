package com.registro.registropersonas.model;

public class Usuario {
    private String nombre;
    private int edad;
    private String rut;
    public Usuario (String nombre, int edad, String rut) {
        this.nombre = nombre;
        this.edad = edad;
        this.rut = rut;
    }
    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }
    public String getRut() {
        return rut;
    }
}
