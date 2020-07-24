/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._interfaces_funcionales.ej3_21;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author chicovi
 */
public class MapTest {
    
    public static void main(String[] args) {
        
        Map<String, String> map = new HashMap<String, String>();
        
        String[][] arreglo = {{"Chris","USA"},{"Raju","India"},{"Lynda","Canada"}};
        
        for (String[] parCV : arreglo) {
            map.put(parCV[0], parCV[1]);
        }
        
        System.out.println("Usando la forma tradicional de imprimir clave y valor de un mapa");
        
        Iterator<Map.Entry<String,String>> iter = map.entrySet().iterator();
        if (iter != null) {
            while(iter.hasNext()) {
                Map.Entry<String, String> entry = iter.next();
                System.out.println("Clave: "+entry.getKey() + "\tValor: "+entry.getValue());
            }
        }
        
        System.out.println("\nUsando BiConsumer y expresiones lambda: ");
        map.forEach((key, value) -> System.out.println("Clave: "+key + "\tValor: "+value));
    }
    
}
