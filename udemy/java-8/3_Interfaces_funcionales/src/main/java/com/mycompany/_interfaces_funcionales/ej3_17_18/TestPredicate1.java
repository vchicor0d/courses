/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._interfaces_funcionales.ej3_17_18;

import java.util.function.Predicate;

/**
 *
 * @author chicovi
 */
public class TestPredicate1 {
    
    public static void main(String[] args) {
        
        /*
        A la interfaz predicate se le pasa un test booleano
        */
        Predicate<Integer> predicate = (valor) -> valor > 0;
        
        System.out.println(predicate.test(123));
    }
    
}
