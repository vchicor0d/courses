/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._interfaces_funcionales.ej3_16;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author chicovi
 */
public class EjercicioBiFunction3 {

    public static void main(String[] args) {

        List<Empleado> listaEmpleados
                = Arrays.asList(
                        new Empleado("Javier", 2563.2),
                        new Empleado("Arturo", 183.2),
                        new Empleado("Carlos", 2648879.2),
                        new Empleado("Jimena", 2546.2),
                        new Empleado("Raul", 2522.2),
                        new Empleado("Ramiro", 254.2),
                        new Empleado("Saul", 23.2),
                        new Empleado("Jaime", 25553.2),
                        new Empleado("Flor", 2123543.2),
                        new Empleado("Mirna", 321653.2)
                );

        Calculadora2 cal = new Calculadora2();

        List<Double> salarios = cal.calc((salario, incremento) -> salario + (salario * (incremento / 100)), listaEmpleados, 16.0);
        
        for (Double salario: salarios) {
            System.out.println(salario);
        }
    }
}
