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
public class Calculadora {
    
    public String calc(BiFunction<Integer, Integer, String> bi, Integer i1, Integer i2) {
        return bi.apply(i1, i2);
    }
    
}
