/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vcr._metodos_referenciados.ej30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 *
 * @author victor
 */
public class EjercicioNew {
    
    public static void main(String[] args) {
        
        List<String> numeros = 
                Arrays.asList("10", "10", "15", "15", "25", "30", "40", "6", "30");
        
        //getResults(numeros, (numString) -> new Integer(numString));
        //getResults(numeros, Integer::new).forEach(num -> System.out.println(num * 10));
        getResults(numeros, Integer::new).forEach(EjercicioNew::multiplicarPor10);
        
    }
    
    
    public static List<Integer> getResults(List<String> datos, Function<String, Integer> func) {
        
        List<Integer> resultados = new ArrayList<>();
        datos.forEach(strNum -> resultados.add(func.apply(strNum)));
        
        return resultados;
    }
    
    public static void multiplicarPor10(int numero) {
        System.out.println("El nuevo valor del dato " + numero + " es: " + numero*10);
    }
}
