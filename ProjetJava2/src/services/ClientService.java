package services;

import ClassesPrincipaux.Client;

public interface ClientService {
	public void insererClient(Client client);
	Client consulterClient(int cin);
	public boolean modifierClient(Client client);
	public void supprimerClient(int cin);
}
