/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._interfaces_funcionales.ej3_24;

import java.util.function.BinaryOperator;

/**
 *
 * @author chicovi
 */
public class BinaryOperatorTest {
    
    public static void main(String[] args) {
        
        /*
        BinaryOperator es una especialización de la interfaz BiFunction análogamente 
        al caso de UnaryOperator con Function
        */
        BinaryOperator<Integer> bop = (num1, num2) -> num1 * num2;
        
        int resultado = bop.apply(10, 20);
        System.out.println("El resultado es: " +resultado);
        
        BinaryOperator<Integer> bopMin = BinaryOperator.minBy((Integer t1, Integer t2) -> t1.compareTo(t2));
        
        resultado = bopMin.apply(10, 20);
        System.out.println("El número menor de 10 y 20 es: " + resultado);
    }
    
}
