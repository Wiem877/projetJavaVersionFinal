package services;

import ClassesPrincipaux.CompteBancaire;

public interface CompteService {
	void creerCompte(CompteBancaire compte);
    CompteBancaire consulterCompte(int numero);
    void modifierCompte(CompteBancaire compte);
    boolean supprimerCompte(int numero);
    public boolean compteExiste(int numCompte);
}
