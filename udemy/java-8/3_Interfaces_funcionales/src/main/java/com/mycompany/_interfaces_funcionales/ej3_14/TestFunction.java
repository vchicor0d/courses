/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._interfaces_funcionales.ej3_14;

import java.util.function.Function;

/**
 *
 * @author chicovi
 */
public class TestFunction {
    public static void main(String[] args) {
        /*
        La interfaz Function aplica una función a un elemento.
        */
        Function<Integer,String> convertidor = x -> Integer.toString(x);
        System.out.println(convertidor.apply(30).length());
        System.out.println(convertidor.apply(3).length());
    }
}
