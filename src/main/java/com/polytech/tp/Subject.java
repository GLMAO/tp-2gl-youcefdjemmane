package com.polytech.tp;

// L'interface Subject définit le contrat pour gérer les observateurs
public interface Subject {
    void registerObserver(Observer observer);
    void unregisterObserver(Observer observer);
    void notifyObservers(String message, Cours coursChange);
}