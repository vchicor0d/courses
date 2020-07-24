/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._interfaces_funcionales.ej3_20.accept_estudiantes;

import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author chicovi
 */
public class OperacionEstudiantes {
    
    public void aceptaTodos(List<Estudiante> estudiantes, Consumer<Estudiante> cons) {
        for (Estudiante estudante : estudiantes) {
            cons.accept(estudante);
        }
    }
    
}
