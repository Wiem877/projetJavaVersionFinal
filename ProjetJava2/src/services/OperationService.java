package services;

import ClassesPrincipaux.CompteBancaire;

public interface OperationService {
	boolean retrait(CompteBancaire compte, float montant);
	boolean versement(CompteBancaire compte, float montant);
	boolean virement(CompteBancaire source, CompteBancaire destination, float montant);
}
