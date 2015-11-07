package com.gcf.modele;

public class MiseAJour {
    private String date;
    private int idAuteur;
    private int idDossier;
    private int idMAJ;
    private String info;
    private String nature;

    public MiseAJour(int idMiseAJ, String d, String nat, String inf, int idAut, int idDos) {
        idMAJ     = idMiseAJ;
        date      = d;
        nature    = nat;
        info      = inf;
        idAuteur  = idAut;
        idDossier = idDos;
    }
    
        public MiseAJour(String nat, String inf, int idAut, int idDos) {
    //    idMAJ     = idMiseAJ;
     //   date      = d;
        nature    = nat;
        info      = inf;
        idAuteur  = idAut;
        idDossier = idDos;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIdAuteur() {
        return idAuteur;
    }

    public void setIdAuteur(int idAuteur) {
        this.idAuteur = idAuteur;
    }

    public int getIdDossier() {
        return idDossier;
    }

    public void setIdDossier(int idDossier) {
        this.idDossier = idDossier;
    }

    public int getIdMAJ() {
        return idMAJ;
    }

    public void setIdMAJ(int idMAJ) {
        this.idMAJ = idMAJ;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
