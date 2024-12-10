package ClassesPrincipaux;

import java.time.LocalDate;

public class CompteBancaire {
	private int numCompte;
    private int cinClient;
    private String password;
    private float solde;
    private LocalDate dateOuverture;
    public CompteBancaire(int numCompte,int cinClient,String password,float solde, LocalDate dateO)
    {
    	this.numCompte=numCompte;
    	this.cinClient=cinClient;
    	this.password=password;
    	this.solde=solde;
    	dateOuverture=dateO;
    }
    public CompteBancaire(int numCompte, String pwd)
    {
    	this.numCompte=numCompte;
    	password=pwd;
    }
    public CompteBancaire(int numCompte)
    {
    	this.numCompte=numCompte;
    	
    }
    
    public int getNumCompte()
    {
    	return numCompte;
    }
    public int getCinClient()
    {
    	return cinClient;
    }
    public float getSolde()
    {
    	return solde;
    }
    public String getPassword()
    {
    	return password;
    }
    public LocalDate getDateOuverture()
    {
    	return dateOuverture;
    }
    public void setNumCompte(int val)
    {
    	numCompte=val;
    }
    public void setCinClient(int val)
    {
    	cinClient=val;
    }
    public void setPassword(String val)
    {
    	password=val;
    }
    public void setSolde(float d)
    {
    	solde=d;
    }
    public void setDateOuverture(LocalDate val)
    {
    	dateOuverture=val;
    }
    
    // Constructeur, getters, setters
    
}
