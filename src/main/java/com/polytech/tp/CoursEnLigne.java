package com.polytech.tp;

public class CoursEnLigne extends CoursDecorator {
    
    public CoursEnLigne(ICours cours) {
        // Appelle le constructeur de la classe parente (CoursDecorator)
        super(cours);
    }

    @Override
    public String getDescription() {
        // Ajoute la nouvelle responsabilité à la description existante (déléguée).
        return coursDecorated.getDescription() + " (En ligne)";
    }

    // Nous déléguons getDuree(), car un cours en ligne a la même durée.
     @Override public double getDuree() { return coursDecorated.getDuree(); } // Non nécessaire car déjà fait dans l'abstrait
}