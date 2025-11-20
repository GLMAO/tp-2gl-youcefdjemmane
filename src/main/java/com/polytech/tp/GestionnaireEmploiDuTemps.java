package com.polytech.tp;

import java.util.ArrayList;
import java.util.List;


public class GestionnaireEmploiDuTemps implements Subject {
    private List<Cours> listeCours = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>(); 

    
    
    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
        System.out.println(" Nouvel observateur enregistré.");
    }

    @Override
    public void unregisterObserver(Observer observer) {
        this.observers.remove(observer);
        System.out.println(" Observateur désenregistré.");
    }

    @Override
    public void notifyObservers(String message, Cours coursChange) {
        System.out.println("\n--- Début de la notification ---");
        // Envoi du message et du cours modifié à tous les observateurs
        for (Observer observer : observers) {
            observer.update(message, coursChange);
        }
        System.out.println("--- Fin de la notification ---\n");
    }

    

    public void ajouterCours(Cours cours) {
        this.listeCours.add(cours);
        notifyObservers("ajouté", cours);
    }


    public void modifierCours(Cours cours, String modification) {
        // Logique de modification...
        System.out.println("Cours modifié : " + modification);
        // Notification après la modification d'un cours
        notifyObservers("modifié (détails : " + modification + ")", cours);
    }
    
    
    public void setChangement(String changement) {
        System.out.println("Changement général : " + changement);
       
    }
}