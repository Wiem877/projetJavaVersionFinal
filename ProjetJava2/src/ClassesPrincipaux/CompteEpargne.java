package ClassesPrincipaux;

import java.time.LocalDate;

public class CompteEpargne extends CompteBancaire{
	private double tauxInteret;
	public CompteEpargne(int numCompte,int cinClient,float solde, LocalDate dateO,double tauxInteret)
	{
		super(numCompte,cinClient,solde,dateO);
		this.tauxInteret=tauxInteret;
	}
	public double getTauxInteret()
	 {
		 return tauxInteret;
	 }
	 public void setTauxInteret(double val)
	 {
		 tauxInteret=val;
	 }
    @Override
    public void afficherDetails() {
        // Affiche les détails du compte épargne
    }
}
