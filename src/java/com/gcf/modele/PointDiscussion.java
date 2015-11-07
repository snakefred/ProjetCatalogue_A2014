package com.gcf.modele;

public class PointDiscussion 
{
    private String etat;
    private int idDossier;
    private int idPointD;
    private int idReunion;
    private String nom;
    private String type;
    private String compteRendu;
   

    public PointDiscussion(String n, String t, String e, int idDos, int idR, String cr) {
   //     idPointD  = idPoint;
        nom       = n;
        type      = t;
        etat      = e;
        idDossier = idDos;
        idReunion = idR;
        compteRendu = cr; 
    }
    
       public PointDiscussion(int idPoint,String n, String t, String e, int idDos, int idR, String cr) {
        idPointD  = idPoint;
        nom       = n;
        type      = t;
        etat      = e;
        idDossier = idDos;
        idReunion = idR;
        compteRendu = cr; 
    }

    public String getCompteRendu() {
        return compteRendu;
    }

    public void setCompteRendu(String compteRendu) {
        this.compteRendu = compteRendu;
    }    
    

    /**
     * @return the etat
     */
    public String getEtat() {
        return etat;
    }

    /**
     * @param etat the etat to set
     */
    public void setEtat(String etat) {
        this.etat = etat;
    }

    /**
     * @return the idDossier
     */
    public int getIdDossier() {
        return idDossier;
    }

    /**
     * @param idDossier the idDossier to set
     */
    public void setIdDossier(int idDossier) {
        this.idDossier = idDossier;
    }

    /**
     * @return the idPointD
     */
    public int getIdPointD() {
        return idPointD;
    }

    /**
     * @param idPointD the idPointD to set
     */
    public void setIdPointD(int idPointD) {
        this.idPointD = idPointD;
    }

    /**
     * @return the idReunion
     */
    public int getIdReunion() {
        return idReunion;
    }

    /**
     * @param idReunion the idReunion to set
     */
    public void setIdReunion(int idReunion) {
        this.idReunion = idReunion;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

   
}


//~ Formatted by Jindent --- http://www.jindent.com
