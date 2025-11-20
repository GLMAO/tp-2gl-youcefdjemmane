package com.polytech.tp;

public class CoursEnAnglais extends CoursDecorator {
    
    public CoursEnAnglais(ICours cours) {
        super(cours);
    }

    @Override
    public String getDescription() {
        // Ajoute la nouvelle responsabilité
        return coursDecorated.getDescription() + " (En anglais)";
    }
}