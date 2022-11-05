/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vcr._metodos_referenciados.ej27;

/**
 *
 * @author victor
 */
public class Persona {
    
    private String nombre;
    private Integer edad;
    private String email;

    public Persona(String nombre, int edad, String email) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "nombre=" +nombre+ ", edad=" + edad;
    }
    
    public static int compararPorEdad(Persona a, Persona b) {
        return a.getEdad().compareTo(b.getEdad());
    }
    
    public int compararPorEdad2(Persona b) {
        return this.getEdad().compareTo(b.getEdad());
    }
    
}
