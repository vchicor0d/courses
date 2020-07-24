/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._interfaces_funcionales.ej3_19;

import com.mycompany._interfaces_funcionales.ej3_17_18.evaluaempleados.Empleado;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

/**
 *
 * @author chicovi
 */
public class Evaluador {
    
    public List<Empleado> evaluar(List<Empleado> listaEmp, 
            BiPredicate<Integer, String> eval) {
        
        List<Empleado> listaNueva = new ArrayList<>();
        
        for (Empleado empleado : listaEmp) {
            if (eval.test(empleado.getEdad(), empleado.getDepartamento())) {
                listaNueva.add(empleado);
            }
        }
        
        return listaNueva;
        
    }
    
}
