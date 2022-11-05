/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._interfaces_funcionales.ej3_20;

import java.util.function.Consumer;

/**
 *
 * @author chicovi
 */
public class TestConsumer {

    public static void main(String[] args) {
        
        /*
        Consumer recibe un argumento y ejecuta una función sobre el
        */
        Consumer<String> cons = x -> System.out.println(x.toUpperCase());
        
        cons.accept("Víctor");
    }
    
}
