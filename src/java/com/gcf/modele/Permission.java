package com.gcf.modele;

public class Permission {
    private int idCatalogue;
    private int idMembre;
    private int valeurPermission;

    public Permission( int idC,int idM, int valeur) {
        idMembre         = idM;
        idCatalogue      = idC;
        valeurPermission = valeur;
    }

    public int getIdMembre() {
        return idMembre;
    }

    public int getIdCatalogue() {
        return idCatalogue;
    }

    public int getValeurPermission() {
        return valeurPermission;
    }

    public void setValeurPermission(int valeurPermission) {
        this.valeurPermission = valeurPermission;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
