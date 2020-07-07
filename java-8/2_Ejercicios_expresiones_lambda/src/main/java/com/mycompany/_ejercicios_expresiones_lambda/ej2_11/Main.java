/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._ejercicios_expresiones_lambda.ej2_11;

/**
 *
 * @author chicovi
 */
public class Main {
    
    public static void main (String [] args) {
        System.out.println(create().calculate(3, 5));
    }
    
    private static CalculadoraInt create() {
        return (x,y) -> x*y;
    }
    
}
