package com.gcf.modele;

public class Dossier {
    private int idDossier;
    private String nom;
    private String type;
    private String etat;
    private int idCreateur;
    private String dateCreation;
    private String dateFermeture;
    private int idCatalogue;

    public Dossier( String nom, String type, String etat, int idCreateur, String dateCreation, String dateFermeture, int idCatalogue) {
        //this.idDossier = idDossier;
        this.nom = nom;
        this.type = type;
        this.etat = etat;
        this.idCreateur = idCreateur;
        this.dateCreation = dateCreation;
        this.dateFermeture = dateFermeture;
        this.idCatalogue = idCatalogue;
    }
    
        
    public Dossier( int idDossier, String nom, String type, String etat, int idCreateur, String dateCreation, String dateFermeture, int idCatalogue) {
        this.idDossier = idDossier;
        this.nom = nom;
        this.type = type;
        this.etat = etat;
        this.idCreateur = idCreateur;
        this.dateCreation = dateCreation;
        this.dateFermeture = dateFermeture;
        this.idCatalogue = idCatalogue;
    }

    public int getIdDossier() {
        return idDossier;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public String getEtat() {
        return etat;
    }

    public int getIdCreateur() {
        return idCreateur;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public String getDateFermeture() {
        return dateFermeture;
    }

    public int getIdCatalogue() {
        return idCatalogue;
    }

    public void setIdDossier(int idDossier) {
        this.idDossier = idDossier;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setIdCreateur(int idCreateur) {
        this.idCreateur = idCreateur;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setDateFermeture(String dateFermeture) {
        this.dateFermeture = dateFermeture;
    }

    public void setIdCatalogue(int idCatalogue) {
        this.idCatalogue = idCatalogue;
    }
}

