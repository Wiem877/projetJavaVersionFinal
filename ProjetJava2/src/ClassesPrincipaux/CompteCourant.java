package ClassesPrincipaux;

import java.time.LocalDate;

public class CompteCourant extends CompteBancaire{
	 private double decouvert;
	 public CompteCourant(int numCompte,int cinClient,float solde, LocalDate dateO,double decouvert)
	 {
		 super(numCompte,cinClient,solde,dateO);
		 this.decouvert=decouvert;
	 }
	 public double getDecouvert()
	 {
		 return decouvert;
	 }
	 public void setDecouvert(double val)
	 {
		 decouvert=val;
	 }
	    @Override
	    public void afficherDetails() {
	        // Affiche les détails du compte courant
	    }
}
