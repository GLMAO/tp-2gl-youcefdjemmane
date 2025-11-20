package com.polytech;

import java.util.Arrays;
import java.util.List;

import com.polytech.tp.Cours;
import com.polytech.tp.CoursBuilder;
import com.polytech.tp.Etudiant;
import com.polytech.tp.GestionnaireEmploiDuTemps;
import com.polytech.tp.ICours;
import com.polytech.tp.Responsable;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Exercice 1 : Construction complexe (Pattern Builder)" );
        Cours coursGL = new CoursBuilder()
        .setMatiere("Genie Logiciel")
        .setEnseignant("Mr Mazar")
        .setSalle("D15-16")
        .setDate("2025-11-20")
        .setHeureDebut("13:00")
        .setNiveau("M1 SAID")
        .build();
        
        System.out.println("creation cours 1 :");
        System.out.println(coursGL.getDescription());  


        

        
        System.out.println("-------------------------------------");

        // --- Exercice 2 (Pattern Observer) ---
        System.out.println( "Exercice 2 : Notification de changement (Pattern Observer)" );
        
        GestionnaireEmploiDuTemps gestionnaire = new GestionnaireEmploiDuTemps();
        // 2. Création des Observateurs avec les cours auxquels ils sont inscrits
        List<Cours> coursEtudiant = Arrays.asList(coursGL);
        Etudiant etudiant = new Etudiant("Youcef", coursEtudiant);
        Responsable responsable = new Responsable("Anis");

        // 3. Enregistrement des Observateurs
        gestionnaire.registerObserver(etudiant);
        gestionnaire.registerObserver(responsable);

        // 4. Déclenchement de la notification 
    
        gestionnaire.modifierCours(coursGL, "Salle changée à A301"); 

        
        Cours coursBD = new CoursBuilder()
            .setMatiere("Bases de Données")
            .setEnseignant("Mr Zalmati")
            .build();
        gestionnaire.ajouterCours(coursBD); 

    }
}
