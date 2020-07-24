/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._interfaces_funcionales.ej3_15;

import java.util.function.Function;

/**
 *
 * @author chicovi
 */
public class DatosComensal {
    
    public static void main(String[] args) {
        
        Comensal comensal = new Comensal("Víctor", 256.2, 5);
        
        String nombreComensal = (String)getDatoComensal(comensal, x -> x.getNombre());
        
        int mesa = (Integer)getDatoComensal(comensal, x -> x.getMesa());
        
        System.out.println("El nombre del comensal es " + nombreComensal);
        System.out.println("La mesa del comensal es la " + mesa);
    }
    
    public static Object getDatoComensal(Comensal com, Function<Comensal,Object> func) {
        return func.apply(com);
    }
    
}
