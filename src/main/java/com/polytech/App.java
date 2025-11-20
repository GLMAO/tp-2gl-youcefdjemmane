package com.polytech;

import com.polytech.tp.Cours;
import com.polytech.tp.CoursBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Exercice 1 : Construction complexe (Pattern Builder)" );
        Cours c = new CoursBuilder()
        .setMatiere("Genie Logiciel")
        .setEnseignant("Mr Mazar")
        .setSalle("D15-16")
        .setDate("2025-11-20")
        .setHeureDebut("13:00")
        .setNiveau("M1 SAID")
        .build();

        System.out.println(c.getDescription());  


    }
}
