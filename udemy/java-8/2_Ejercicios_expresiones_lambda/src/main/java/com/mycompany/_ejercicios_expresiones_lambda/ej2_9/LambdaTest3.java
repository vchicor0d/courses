/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._ejercicios_expresiones_lambda.ej2_9;

/**
 *
 * @author chicovi
 */
public class LambdaTest3 {
    
    public static void main (String [] args) {
        
        engine((x, y) -> x + y);
        engine((x, y) -> x - y);
        engine((x, y) -> x * y);
        engine((x, y) -> x / y);
        engine((x, y) -> x % y);
        
    }
    
    private static void engine (Calculadora cal) {
        
        int x=4, y=5;
        double resultado = cal.calcular(x, y);
        System.out.println(resultado);
        
    }
    
}
