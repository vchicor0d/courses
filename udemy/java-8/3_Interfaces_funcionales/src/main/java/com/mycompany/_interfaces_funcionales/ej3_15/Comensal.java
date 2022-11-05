/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._interfaces_funcionales.ej3_15;

/**
 *
 * @author chicovi
 */
public class Comensal {
    
    String nombre;
    double monto_pedido;
    int mesa;
    
    public Comensal (String nombre, double monto, int mesa) {
        this.nombre = nombre;
        this.monto_pedido = monto;
        this.mesa = mesa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMonto_pedido() {
        return monto_pedido;
    }

    public void setMonto_pedido(double monto_pedido) {
        this.monto_pedido = monto_pedido;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }
    
    
    
}
