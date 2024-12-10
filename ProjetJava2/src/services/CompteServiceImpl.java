package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ClassesPrincipaux.CompteBancaire;
import ClassesPrincipaux.CompteCourant;
import ClassesPrincipaux.CompteEpargne;
import ClassesPrincipaux.Connecter;

public class CompteServiceImpl implements CompteService{
	private static final String URL = "jdbc:mysql://localhost:3306/gestion"; // Remplacez par votre URL
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    public CompteServiceImpl()
    {
    	
    }
	public void creerCompte(CompteBancaire compte) {
        String query = "INSERT INTO compte(numCompte, numCin, password, solde, dateOuverture) VALUES ( ?, ?, ?, ?, ?)";
        //Connection connection;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(query)) {
               statement.setInt(1, compte.getNumCompte());
               statement.setInt(2, compte.getCinClient());
               statement.setString(3, compte.getPassword());
               statement.setFloat(4, compte.getSolde());
               
               statement.setDate(5, java.sql.Date.valueOf(compte.getDateOuverture()));
               if(compte instanceof CompteCourant )
               {
            	   statement.setDouble(6, ((CompteCourant)compte).getDecouvert());
               }
               if(compte instanceof CompteEpargne )
               {
            	   statement.setDouble(6, ((CompteEpargne)compte).getTauxInteret());
               }
               statement.executeUpdate();
               System.out.println("compte inséré avec succés");
           } catch (SQLException e) {
               e.printStackTrace();
           }
    }
	public CompteBancaire consulterCompte(int numCompte) {
        String query = "SELECT * FROM compte WHERE numCompte = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, numCompte);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return new CompteBancaire(rs.getInt("numCompte"),rs.getInt("numCin") ,rs.getString("password"),rs.getFloat("solde"),rs.getDate("dateOuverture").toLocalDate());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
	public void modifierCompte(CompteBancaire compte) {
        String query = "UPDATE compte SET password = ? WHERE numCompte = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, compte.getPassword());
            statement.setInt(2, compte.getNumCompte());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	public boolean supprimerCompte(int numero) {
		if (numero <= 0) {
	        throw new IllegalArgumentException("Le numéro de compte doit être un entier positif.");
	    }

	    // Requête SQL pour supprimer un compte
	    String query = "DELETE FROM compte WHERE numCompte = ?";

	    try (Connection connection = Connecter.obtenirConnection();
	            PreparedStatement statement = connection.prepareStatement(query)) {
	           
	    	statement.setInt(1, numero);
	           int rowsAffected = statement.executeUpdate();

	        // Exécute la mise à jour (suppression)

	        // Vérifie si un compte a été supprimé
	        if (rowsAffected == 0) {
	            System.out.println("Aucun compte avec ce numéro n'a été trouvé.");
	            return false;
	        } else {
	            System.out.println("Compte supprimé avec succès.");
	            return true;
	        }
	    } catch (SQLException e) {
	        // Journalise l'erreur avec un message explicite
	        System.err.println("Erreur lors de la suppression du compte avec numéro : " + numero);
	        e.printStackTrace();
	        return false;// À remplacer par un logger dans un vrai projet
	    }
    }
	public boolean compteExiste(int numCompte) {
	    String query = "SELECT COUNT(*) FROM compte WHERE numCompte = ?";
	    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
	         PreparedStatement statement = connection.prepareStatement(query)) {
	        statement.setInt(1, numCompte);
	        try (ResultSet rs = statement.executeQuery()) {
	            if (rs.next()) {
	                return rs.getInt(1) > 0; // Retourne true si le compte existe
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
}
