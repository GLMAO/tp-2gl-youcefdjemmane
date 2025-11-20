package com.polytech.tp;

public class CoursBuilder {
    // TODO: Implémenter le pattern Builder
    private String matiere;
    private String enseignant;
    private String salle;
    private String date;
    private String heureDebut;
    private boolean estOptionnel;
    private String niveau;
    private boolean necessiteProjecteur;
    
    
     public CoursBuilder setMatiere(String matiere) {
        this.matiere = matiere;
        return this;
    }

    public CoursBuilder setEnseignant(String enseignant) {
        this.enseignant = enseignant;
        return this;
    }

    public CoursBuilder setSalle(String salle) {
        this.salle = salle;
        return this;
    }

    public CoursBuilder setDate(String date) {
        this.date = date;
        return this;
    }

    public CoursBuilder setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
        return this;
    }

    public CoursBuilder setEstOptionnel(boolean estOptionnel) {
        this.estOptionnel = estOptionnel;
        return this;
    }

    public CoursBuilder setNiveau(String niveau) {
        this.niveau = niveau;
        return this;
    }

    public CoursBuilder setNecessiteProjecteur(boolean necessiteProjecteur) {
        this.necessiteProjecteur = necessiteProjecteur;
        return this;
    }
    
    
    public String getMatiere() { return matiere; }
    public String getEnseignant() { return enseignant; }
    public String getSalle() { return salle; }
    public String getDate() { return date; }
    public String getHeureDebut() { return heureDebut; }
    public boolean isEstOptionnel() { return estOptionnel; }
    public String getNiveau() { return niveau; }
    public boolean isNecessiteProjecteur() { return necessiteProjecteur; }

    public Cours build() {
        return new Cours(this);
    }
}