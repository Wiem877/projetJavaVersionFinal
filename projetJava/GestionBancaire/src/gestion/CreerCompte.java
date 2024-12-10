package gestion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class CreerCompte {
	public CreerCompte()
	{
		
	}
	static void insererCompte(String cin,String num,String soldee,Date date)
	{
		 if (cin == null || !cin.matches("\\d+")) {
	            System.out.println("Le CIN doit être un entier valide.");
	            return;
	        }

	        if (soldee == null || !soldee.matches("\\d+(\\.\\d+)?")) {
	            System.out.println("Le solde doit être un nombre valide.");
	            return;
	        }

	        int numCin = Integer.parseInt(cin);
	        float solde = Float.parseFloat(soldee);
	        String sql = "INSERT INTO compte (numCompte, cinClient, solde, dateOuverture) VALUES (?, ?, ?, ?)";

	        // Connexion et insertion
	        try (Connection conn = Connecter.obtenirConnection();
	             PreparedStatement statement = conn.prepareStatement(sql)) {

	            // Paramétrer la requête avec les données du compte
	            statement.setString(1, num);
	            statement.setInt(2, numCin);
	            statement.setDouble(3, solde);
	            statement.setDate(4, date);

	            // Exécuter la requête
	            int lignesAffectees = statement.executeUpdate();

	            if (lignesAffectees > 0) {
	                System.out.println("Compte inséré avec succès !");
	            } else {
	                System.out.println("Échec de l'insertion du compte.");
	            }

	        } catch (SQLIntegrityConstraintViolationException e) {
	            System.out.println("Erreur : Contrainte violée (par exemple, clé primaire en double).");
	            e.printStackTrace();
	        } catch (SQLException e) {
	            System.out.println("Erreur lors de l'insertion dans la base de données : " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	}

