/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._interfaces_funcionales.ej3_26;

import java.util.Comparator;

/**
 *
 * @author chicovi
 */
public class OrdenarPersonaPorId implements Comparator<Persona>{
    
    @Override
    public int compare(Persona o1, Persona o2) {
        return o1.getIdPersona() - o2.getIdPersona();
    }
    
}
