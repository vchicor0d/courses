/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._interfaces_funcionales.ej3_21;

import java.util.function.BiConsumer;

/**
 *
 * @author chicovi
 */
public class InterfazBiConsumerTest {
    
    public static void main(String[] args) {
        
        BiConsumer<Double, Double> biConsumer = 
                (num1, num2) -> System.out.println("La multiplicación es: " + num1*num2);
        
        biConsumer.accept(15.2, 2.4);
        
    }
    
}
