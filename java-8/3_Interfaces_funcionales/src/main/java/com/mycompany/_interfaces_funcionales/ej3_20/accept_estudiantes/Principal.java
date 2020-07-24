/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._interfaces_funcionales.ej3_20.accept_estudiantes;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author chicovi
 */
public class Principal {
    
    public static void main(String[] args) {
        
        List<Estudiante> estudiantes = Arrays.asList(
                new Estudiante("John", 6),
                new Estudiante("Mark", 5),
                new Estudiante("Felix", 5),
                new Estudiante("Patrick", 6),
                new Estudiante("James", 3),
                new Estudiante("Peter", 10),
                new Estudiante("Mathew", 10),
                new Estudiante("Paul", 9),
                new Estudiante("James", 5),
                new Estudiante("Judas", 4),
                new Estudiante("Tomas", 8),
                new Estudiante("Felipe", 7),
                new Estudiante("Tom", 6),
                new Estudiante("Maria", 7),
                new Estudiante("Magdala", 7),
                new Estudiante("Javier", 7),
                new Estudiante("Amanda", 8),
                new Estudiante("Amada", 6),
                new Estudiante("Olivia", 9),
                new Estudiante("Cinthia", 9),
                new Estudiante("Felicias", 10),
                new Estudiante("Mancera", 5),
                new Estudiante("Arturo", 2),
                new Estudiante("Abdías", 10)
        );
        
        OperacionEstudiantes op = new OperacionEstudiantes();
        
        Consumer<Estudiante> cons1 = e -> System.out.println("Nombre: " + e.getNombre() + " Calificación: " + e.getCalificacion());
        Consumer<Estudiante> cons2 = e -> e.setCalificacion(e.getCalificacion() * 1.15);
        
        System.out.println("Estudantes con calificación original");
        op.aceptaTodos(estudiantes, cons1);
        
        /*
        op.aceptaTodos(estudiantes, cons2);
        System.out.println("Estudiantes con calificaición actualizada");
        op.aceptaTodos(estudiantes, cons1);
        */
        
        System.out.println("Estudiantes con calificaición actualizada");
        op.aceptaTodos(estudiantes, cons2.andThen(cons1));
    }
    
}
