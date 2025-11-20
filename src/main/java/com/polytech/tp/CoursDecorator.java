package com.polytech.tp;

// L'Abstract Decorator implémente le Component (ICours) et contient une référence à celui-ci.
public abstract class CoursDecorator implements ICours {
    protected ICours coursDecorated;

    public CoursDecorator(ICours cours) {
        this.coursDecorated = cours;
    }
    
    // Implémentation par défaut : Délégué l'appel à l'objet décoré.
    // Cela permet de ne redéfinir que les méthodes qui doivent être étendues (comme getDescription).
    
    @Override
    public String getDescription() {
        return coursDecorated.getDescription();
    }

    @Override
    public double getDuree() {
        return coursDecorated.getDuree();
    }
}