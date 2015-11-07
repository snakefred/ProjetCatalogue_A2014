package com.gcf.modele;

public class MembreOperation {
    private String dateHeure;
    private String desciption;
    private int    idCatalogue;
    private int    idMembre;

    public MembreOperation(int idMem, int idCat, String dateHre, String desc) {
        idMembre    = idMem;
        idCatalogue = idCat;
        dateHeure   = dateHre;
        desciption  = desc;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
