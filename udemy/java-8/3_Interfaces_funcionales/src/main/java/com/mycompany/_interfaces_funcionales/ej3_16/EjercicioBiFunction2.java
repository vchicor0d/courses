/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._interfaces_funcionales.ej3_16;

/**
 *
 * @author chicovi
 */
public class EjercicioBiFunction2 {
    
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        String resultado = calculadora.calc((x, y) -> ": " + (x * y), 60, 10);
        
        System.out.println("El resultado es " + resultado);
    }
    
}
