/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vcr._metodos_referenciados.ej28;

import com.vcr._metodos_referenciados.ej27.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author victor
 */
public class Principal {
    
    public static void main(String[] args) {
        
        List<Persona> personas =
            Arrays.asList(
                    new Persona("Juan", 18, "juanito@hotmail.com"),
                    new Persona("Mario", 17, "mario@hotmail.com"),
                    new Persona("Arturo", 17, "arturito@htomail.com"),
                    new Persona("Maria", 15, "maria@htomail.com"),
                    new Persona("Beatriz", 14, "bety@hotmail.com"),
                    new Persona("Olivia", 12, "oli@hotmail.com"),
                    new Persona("Ángel", 25, "angelito@htomail.com"),
                    new Persona("Omar", 32, "omarcito@htomail.com"),
                    new Persona("Pamela", 28, "pamelita@htomail.com"),
                    new Persona("Sadee", 25, "sacecita@hotmail.com"),
                    new Persona("Jared", 12, "jaredcito@htomail.com"),
                    new Persona("Sheree", 30, "shereewindle@hotgirl.com"),
                    new Persona("Javier", 18, "javiercito@hotmail.com"),
                    new Persona("Roberto", 20, "robertito@hotmail.com"),
                    new Persona("Oyuki", 22, "oyukita@hotmail.com"),
                    new Persona("Linda", 25, "lindita@hotmail.com"),
                    new Persona("Gustavo", 14, "tavito@hotmail.com"),
                    new Persona("Lourdes", 15, "lulita@hotmail.com"),
                    new Persona("Raquel", 16, "raquelita@hotmail.com")
            );
        
        ProveedorComparaciones comparador = new ProveedorComparaciones();
        
        Collections.sort(personas, comparador::compararPorNombre);
        
        System.out.println("Personas ordenadas por nombre: ");
        personas.forEach(System.out::println);
    }
    
}
