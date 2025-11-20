package com.polytech.tp;

import java.util.List;

public class Etudiant implements Observer{
    private String nom;
    private List<Cours> coursInscrits; 

    public Etudiant(String nom, List<Cours> coursInscrits) {
        this.nom = nom;
        this.coursInscrits = coursInscrits;
    }
    
   @Override
    public void update(String action, Cours coursChange) {
        
        if (coursInscrits != null && coursInscrits.contains(coursChange)) {
            System.out.println(" Notification pour l'étudiant " + this.nom + " : Le cours '" + coursChange.getMatiere() + "' a été " + action + ".");
        }
    }
}