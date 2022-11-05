/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._interfaces_funcionales.ej3_16;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

/**
 *
 * @author chicovi
 */
public class Calculadora2 {
    public List<Double> calc(BiFunction<Double, Double, Double> bi, List<Empleado> listaEmp, Double incremento) {
        
        List<Double> listaSalarios = new ArrayList<>();
        
        for (Empleado empleado : listaEmp) {
            listaSalarios.add(bi.apply(empleado.getSalario(), incremento));
        }
        
        return listaSalarios;
    }
}
