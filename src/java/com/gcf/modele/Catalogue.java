package com.gcf.modele;

public class Catalogue
{
  private String  nomCatalogue, dateCreation, code;
  private int numeroCat,numProprietaire;
  
  public Catalogue( String nomCatalogue, int numProprietaire, String dateCreation, String code)
  {
	  //this.numeroCat = numeroCat;
	  this.nomCatalogue = nomCatalogue;
	  this.numProprietaire = numProprietaire;
	  this.dateCreation = dateCreation;
	  this.code = code;	  
  }
  
    public Catalogue(int numeroCat, String nomCatalogue, int numProprietaire, String dateCreation, String code)
  {
	  this.numeroCat = numeroCat;
	  this.nomCatalogue = nomCatalogue;
	  this.numProprietaire = numProprietaire;
	  this.dateCreation = dateCreation;
	  this.code = code;	  
  }
  
  public int getNumeroCat()
  {
	return numeroCat;  
  }
  
  public void setNumeroCat(int numeroCat)
  {
	  this.numeroCat = numeroCat;	  
  }
  
  
  public String getNomCatalogue()
  {
	return nomCatalogue;  
  }
  
  public void setNomCatalogue(String nomCatalogue)
  {
	  this.nomCatalogue = nomCatalogue;	  
  }
  
  public int getNumproprietaire()
  {
	  return numProprietaire;
  }
  
  public void setNumProprietaire(int numProprietaire)
  {
	  this.numProprietaire = numProprietaire;
  }
  
  public String getdateCreation()
  {
	  return dateCreation;
  }
  
  public void setDateCreatione(String dateCreation)
  {
	  this.dateCreation = dateCreation;
  }
  
  public String getCode()
  {
	  return code;	  
  }
  
  public void setCode(String code)
  {
	  this.code = code;
  }
}
