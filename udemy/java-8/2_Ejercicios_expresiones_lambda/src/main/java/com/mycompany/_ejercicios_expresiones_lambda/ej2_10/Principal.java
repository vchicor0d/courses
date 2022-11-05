/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._ejercicios_expresiones_lambda.ej2_10;

/**
 *
 * @author chicovi
 */
public class Principal {
    
    public static void main (String [] args) {
        //En este caso, la expresión:
        //engine((x,y) -> x + y);
        //Dará un error porque el compilador no puede inferir el tipo de los parámetros
        // y por lo tanto no puede inferir la interfaz de la que se trata,
        // el método es ambiguo
        // es necesario especificar el tipo del parámetro
        
        //Podemos poner los tipos de los parametros
        engine((long x, long y) -> x + y);
        
        //O podemos hacer un cast de la interfaz
        engine((CalculadoraInt)(x,y) -> x + y);
        
        //También podemos crear una instancia de la interfaz
        CalculadoraLong cl = (x,y) -> x -y;
        
        // y llamar al método
        engine(cl);
        
    }
    
    public static void engine(CalculadoraInt cal) {
        
    }
    
    public static void engine(CalculadoraLong cal) {
        
    }
    
}
