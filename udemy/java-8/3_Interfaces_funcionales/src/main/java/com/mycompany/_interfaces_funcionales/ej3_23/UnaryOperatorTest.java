/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._interfaces_funcionales.ej3_23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 *
 * @author chicovi
 */
public class UnaryOperatorTest {
    
    public static void main(String[] args) {
        
        /*
        UnaryOperator hereda de Function y es una especialización de la misma
        cuyos parámetros de entrada y salida son del mismo tipo.
        */
        List<Integer> lista = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80 ,90, 100);
        
        List<Integer> listaAct = operadorUnary(num -> num * num, lista);
        
        listaAct.forEach(num -> System.out.println(num));
    }
    
    public static List<Integer> operadorUnary(UnaryOperator<Integer> unaryOpt, List<Integer> lista) {
        
        List<Integer> listaActualizada = new ArrayList<>();
        
        /*
        Recorremos la lista parámetro y, para cada elemento num de la misma, le vamos a añadir
        a la listaActualizada el resultado de aplicar UnaryOperator sobre ese número
        */
        lista.forEach(num -> listaActualizada.add(unaryOpt.apply(num)));
        
        return listaActualizada;
        
    }
    
}
