/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._ejercicios_expresiones_lambda.ej2_8;

/**
 *
 * @author chicovi
 */
public class LambdaTest2 {
    
    public static void main (String [] args) {
        
        Operaciones op = (a, b) -> System.out.println(a + b);
        
        
        LambdaTest2 lt2 = new LambdaTest2();
        lt2.metodo(op, 2, 3);
        
        lt2.metodo((a, b) -> System.out.println(a - b), 2, 3);
        
    }
    
    private void metodo (Operaciones op, int a, int b) {
        op.imprimeOperacion(a, b);
    }
    
}
