package com.polytech.tp;

public class Cours implements ICours {
    private String matiere;
    private String enseignant;
    private String salle;
    private String date;
    private String heureDebut;
    private boolean estOptionnel;
    private String niveau;
    private boolean necessiteProjecteur;

    
     Cours(CoursBuilder builder) {
        this.matiere = builder.getMatiere();
        this.enseignant = builder.getEnseignant();
        this.salle = builder.getSalle();
        this.date = builder.getDate();
        this.heureDebut = builder.getHeureDebut();
        this.estOptionnel = builder.isEstOptionnel();
        this.niveau = builder.getNiveau();
        this.necessiteProjecteur = builder.isNecessiteProjecteur();
    }

    @Override
    public String getDescription() {
      return "Cours : " + matiere + "\n"
         + "Enseignant : " + enseignant + "\n"
         + "Salle : " + salle + "\n"
         + "Date : " + date + "\n"
         + "Heure : " + heureDebut + "\n"
         + "Niveau : " + niveau;
    }


    @Override
    public double getDuree() {
        return 1.5; 
    }
    
    
    public String getMatiere() { return matiere; }
    public String getEnseignant() { return enseignant; }
}