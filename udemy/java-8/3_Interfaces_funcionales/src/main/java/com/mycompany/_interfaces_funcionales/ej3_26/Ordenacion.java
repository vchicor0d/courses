/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._interfaces_funcionales.ej3_26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author chicovi
 */
public class Ordenacion {
    
    public static void main(String[] args) {
        
        List<String> nombres = Arrays.asList("Carlos", "Ana", "Abías", "Germán");
        
        System.out.println("Lista antes de ordenarse: "+nombres);
        
        Collections.sort(nombres);
        
        System.out.println("Lista después de ordenarse: "+nombres);
        
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Mario"));
        personas.add(new Persona(2, "Fernando"));
        personas.add(new Persona(3, "Omar"));
        personas.add(new Persona(4, "Juana"));
        
        
        System.out.println("Lista de personas desordenadas: " + personas);
        
        Collections.sort(personas);
        System.out.println("Lista de personas ordenadas por nombre: " + personas);
        
        Collections.sort(personas, new OrdenarPersonaPorId());
        System.out.println("Lista de personas ordenadas por ID: " + personas);
        
        /*
        El ejemplo anterior se puede hacer creando una clase anónima en lugar de crear una nueva clase
        */
        Collections.sort(personas, new Comparator<Persona>() {
            @Override
            public int compare(Persona p1, Persona p2) {
                return p1.getIdPersona() - p2.getIdPersona();
            }
        });
        System.out.println("Lista de personas ordenadas por ID con clase anónima: " + personas);
        
        /*
        Por supuesto podemos usar una función lambda, ya que Comparator es una interfaz funcional
        */
        Collections.sort(personas, (p1, p2) -> p1.getIdPersona() - p2.getIdPersona());
        System.out.println("Lista de personas ordenadas por ID con lambda: " + personas);
    }
    
}
