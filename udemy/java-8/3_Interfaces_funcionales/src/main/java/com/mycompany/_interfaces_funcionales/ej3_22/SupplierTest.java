/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._interfaces_funcionales.ej3_22;

import java.util.function.Supplier;

/**
 *
 * @author chicovi
 */
public class SupplierTest {
    
    public static void main(String[] args) {
        
        /*
        Supplier no admite parámetros y devuelve un objeto del tipo especificado
        */
        Supplier<String> sup = () -> "Hola, Mundo";
        
        System.out.println(sup.get());
        
    }
    
}
