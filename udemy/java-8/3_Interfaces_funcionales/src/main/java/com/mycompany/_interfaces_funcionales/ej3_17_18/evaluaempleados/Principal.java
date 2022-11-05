/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._interfaces_funcionales.ej3_17_18.evaluaempleados;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author chicovi
 */
public class Principal {
    
    public static void main(String[] args) {
        
        List<Empleado> listaEmpleados = Arrays.asList(
                new Empleado("Rodrigo", 25, 1500, "Cobranzas"),
                new Empleado("Alicia", 25, 1500, "Ventas"),
                new Empleado("Manolo", 30, 1500, "Ventas"),
                new Empleado("Cinthia", 20, 2500, "Mostrador"),
                new Empleado("Esteban", 19, 7000, "Ventas"),
                new Empleado("Dámaris", 32, 600, "Telemarketing"),
                new Empleado("Lina", 25, 2500, "Mostrador"),
                new Empleado("Nayeli", 44, 10000, "Ventas"),
                new Empleado("Flor", 35, 7000, "Compras"),
                new Empleado("German", 20, 1500, "Facturación"),
                new Empleado("Lidia", 21, 600, "Telemarketing"),
                new Empleado("Eleazar", 33, 600, "Cobranzas"),
                new Empleado("Javier", 35, 600, "Cobranzas"),
                new Empleado("Paola", 50, 1500, "Compras"),
                new Empleado("Ignacio", 41, 1500, "Compras"),
                new Empleado("Rodrigo", 40, 7000, "Recursos Humanos")
        );
        
        Evaluador evaluador = new Evaluador();
        
        System.out.println("Empleados con salario > 5000");
        List<Empleado> empSalariosAltos = evaluador.evaluar(
                listaEmpleados, empleado -> empleado.getSalario() > 5000);
        
        for (Empleado empleado : empSalariosAltos) {
            System.out.println(empleado.getNombre());
        }
        
        System.out.println("\nEmpleados cuyo nombre empieza por J: ");
        
        List<Empleado> empEmpiezanJ =
                evaluador.evaluar(listaEmpleados,
                        empleado -> empleado.getNombre().startsWith("J"));
        
        for (Empleado empleado : empEmpiezanJ) {
            System.out.println(empleado.getNombre());
        }
        
        System.out.println("\nEmpleados jóvenes: ");
        List<Empleado> empleadosJovenes = 
                evaluador.evaluar(listaEmpleados,
                        empleado -> empleado.getEdad() < 25);
        
        for (Empleado empleado : empleadosJovenes) {
            System.out.println(empleado.getNombre());
        }
        
        Funciones func = new Funciones();
        
        for (Empleado empleado : empleadosJovenes) {
            double nuevoSalario = func.incrementoSalario(
                empleado, 10,
                    (salario, incremento) -> salario + (salario * (incremento/100)));
            empleado.setSalario(nuevoSalario);
        }
        
        System.out.println("\nSalarios actualizados en los jóvenes");
        for (Empleado empleado : empleadosJovenes) {
            System.out.println("Nombre: " + empleado.getNombre() + " Salario: " + empleado.getSalario());
        }
        
        System.out.println("\nEmpleados mayores: ");
        List<Empleado> empleadosMayores = 
                evaluador.negar(listaEmpleados,
                        empleado -> empleado.getEdad() < 25);
        
        for (Empleado empleado : empleadosMayores) {
            System.out.println(empleado.getNombre());
        }
        
    }
    
}
