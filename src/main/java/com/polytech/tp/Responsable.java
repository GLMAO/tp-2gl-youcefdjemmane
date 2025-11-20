package com.polytech.tp;

// Responsable est un Observateur (Observer)
public class Responsable implements Observer {
    private String nom;

    public Responsable(String nom) {
        this.nom = nom;
    }

    @Override
    public void update(String action, Cours coursChange) {
        System.out.println(" Notification pour le responsable " + nom + " : Le cours '" + coursChange.getMatiere() + "' a été " + action + ".");
    }
}