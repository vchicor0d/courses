/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._interfaces_funcionales.ej3_16;

import java.util.function.BiFunction;

/**
 *
 * @author chicovi
 */
public class EjercicioBiFunction {
    
    public static void main(String[] args) {
        /*
        La interfaz BiFunction aplica una función a dos elementos
        */
        BiFunction<String, String, String> bi = (x, y) -> x + y;
        System.out.println(bi.apply("Hola, ", "mundo"));
    }
    
}
