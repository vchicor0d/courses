/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._interfaces_funcionales.ej3_19;

import java.util.function.BiPredicate;

/**
 *
 * @author chicovi
 */
public class TestBiPredicate {

    public static void main(String[] args) {
        
        /*
        La interfaz BiPredicate aplica un test a 2 elementos
        */
        BiPredicate<Integer, Integer> bp = 
                (x, y) -> x < y;
        
        System.out.println(bp.test(2, 3));
    }
    
}
