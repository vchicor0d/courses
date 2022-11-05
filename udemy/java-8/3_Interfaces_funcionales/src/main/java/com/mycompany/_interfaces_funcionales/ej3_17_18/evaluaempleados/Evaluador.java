/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._interfaces_funcionales.ej3_17_18.evaluaempleados;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author chicovi
 */
public class Evaluador {
    
    public List<Empleado> evaluar(List<Empleado> listaEmp, Predicate<Empleado> eval) {
        
        List<Empleado> listaNueva = new ArrayList<>();
        
        for (Empleado empleado : listaEmp) {
            if(eval.test(empleado)) {
                listaNueva.add(empleado);
            }
        }
        
        return listaNueva;
    }
    
    public List<Empleado> negar(List<Empleado> listaEmp, Predicate<Empleado> eval) {
        
        List<Empleado> listaNueva = new ArrayList<>();
        
        for (Empleado empleado : listaEmp) {
            if(eval.negate().test(empleado)) {
                listaNueva.add(empleado);
            }
        }
        
        return listaNueva;
    }
    
}
