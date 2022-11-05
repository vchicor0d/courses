/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vcr._metodos_referenciados.ej28;

import com.vcr._metodos_referenciados.ej27.Persona;

/**
 *
 * @author victor
 */
public class ProveedorComparaciones {
    
    public int compararPorNombre(Persona per1, Persona per2) {
        return per1.getNombre().compareTo(per2.getNombre());
    }
    
    public int compararPorEdad(Persona a, Persona b) {
        return a.getEdad().compareTo(b.getEdad());
    }
    
}
