package com.gcf.modele;

public class Reunion {
    private String date;
    private String etat;
    private int idCatalogue;
    private int idCreateur;
    private int idReunion;
    private String titre;

    public Reunion(String dateReunion, String titr, int idCreator, String e, int idCat) {
   //     idReunion   = idReu;
        date        = dateReunion;
        titre  = titr;
        idCreateur  = idCreator;
        etat        = e;
        idCatalogue = idCat;
    }
    
        public Reunion(int idReu,String dateReunion, String titr, int idCreator, String e, int idCat) {
        idReunion   = idReu;
        date        = dateReunion;
        titre  = titr;
        idCreateur  = idCreator;
        etat        = e;
        idCatalogue = idCat;
    }

    public int getIdReunion() {
        return idReunion;
    }

    public String getDate() {
        return date;
    }

    public String getTitre() {
        return titre;
    }

    public int getIdCreateur() {
        return idCreateur;
    }

    public String getEtat() {
        return etat;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getIdCatalogue() {
        return idCatalogue;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
