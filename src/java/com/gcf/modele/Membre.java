package com.gcf.modele;

public class Membre 
{
	private String  nom, motDePasse, courriel;
	private int actif;
        private int numero,catalogueDefaut;
	
	//constructeurs
	public Membre(String nom, String motDePasse, String courriel, int actif)
	{
		//this.numero =numero;
		this.nom = nom;
		this.motDePasse = motDePasse;  
		this.courriel = courriel;
		this.actif = actif;
       //         this.catalogueDefaut=catalogueDefaut;
	}
        
        	public Membre(int numero, String nom, String motDePasse, String courriel, int actif, int catalogueDefaut)
	{
		this.numero =numero;
		this.nom = nom;
		this.motDePasse = motDePasse;  
		this.courriel = courriel;
		this.actif = actif;
                this.catalogueDefaut=catalogueDefaut;
	}
	
	public int getNumero()
	{
		return numero;
	}
	
	public void setNumero(int numero)
	{
	   this.numero = numero;	
		
	}
	
	public String getNom()
	{
		return nom;
	}
	
	public void setNom(String nom)
	{
	   this.nom = nom;	
		
	}
	
	public String getMotDePasse()
	{
		return motDePasse;
	}
	
	public void setMotDePasse(String motDePasse)
	{
	   this.motDePasse = motDePasse;	
		
	}
	
	public String getCourriel()
	{
		return courriel;
	}
	
	public void setCourriel(String courriel)
	{
		this.courriel= courriel;
	}

	public int getActif()
	{
		return actif;
	}
	

    /**
     * @return the catalogueDefaut
     */
    public int getCatalogueDefaut() {
        return catalogueDefaut;
    }

    /**
     * @param catalogueDefaut the catalogueDefaut to set
     */
    public void setCatalogueDefaut(int catalogueDefaut) {
        this.catalogueDefaut = catalogueDefaut;
    }
}
