/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._ejercicios_expresiones_lambda.ej2_7;

/**
 *
 * @author chicovi
 */
public class LambdaTest {
    
    public static void main(String [] args) {
        FunctionTest functionTest = () -> System.out.println("Hola, Mundo");
        
        functionTest.saludar();
        
        LambdaTest test = new LambdaTest();
        test.miMetodo(() -> System.out.println("Adios, Mundo"));
    }
    
    public void miMetodo(FunctionTest parametro) {
        parametro.saludar();
    }
    
}
