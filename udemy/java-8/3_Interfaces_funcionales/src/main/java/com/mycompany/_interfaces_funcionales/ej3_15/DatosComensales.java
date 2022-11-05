/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._interfaces_funcionales.ej3_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 *
 * @author chicovi
 */
public class DatosComensales {
    
    public static void main(String[] args) {
        List<Comensal> listaComensales = 
        Arrays.asList(new Comensal("Javier", 10, 5),
                      new Comensal("Víctor", 25, 1),
                      new Comensal("María", 31, 2),
                      new Comensal("Elena", 132, 3),
                      new Comensal("Miguel", 31, 4));
        
        List<Object> nombreComensales = getDatosComensales(listaComensales, x -> x.getNombre());
        System.out.println("La lista de comensales es la siguiente: ");
        for (Object nombreComensal : listaComensales) {
            System.out.println("El nombre es: "+ nombreComensal);
        }
    }
    
    public static List<Object> getDatosComensales(List<Comensal> listaComensales, Function<Comensal, Object> func) {
        
        //Guarda datos personalizados de los comensales
        List <Object> listaDatos = new ArrayList<>();
        
        //Itera la lista de comensales que recibimos
        for (Comensal comensal : listaComensales) {
            listaDatos.add(func.apply(comensal));
        }
        return listaDatos;
    }
}
