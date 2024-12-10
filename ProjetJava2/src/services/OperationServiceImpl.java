package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ClassesPrincipaux.CompteBancaire;
import ClassesPrincipaux.CompteCourant;
import ClassesPrincipaux.CompteEpargne;

public class OperationServiceImpl implements OperationService{
	private Connection connection;
    public OperationServiceImpl() {
        try {
            // Connexion à la base de données
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public boolean retrait(CompteBancaire compte, float montant) {
		String query = "UPDATE compte SET solde = solde - ? WHERE numCompte = ? AND solde >= ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
        	statement.setFloat(1, montant);
        	statement.setInt(2, compte.getNumCompte());
        	statement.setFloat(3, montant);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    

    public boolean versement(CompteBancaire compte, float montant) {
    	String query = "UPDATE compte SET solde = solde + ? WHERE numCompte = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
        	statement.setFloat(1, montant);
        	statement.setInt(2, compte.getNumCompte());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean virement(CompteBancaire source, CompteBancaire destination, float montant) {
    	try {
            connection.setAutoCommit(false);

            // Retirer du compte source
            if (!retrait(source, montant)) {
                connection.rollback();
                return false;
            }

            // Verser au compte destination
            if (!versement(destination, montant)) {
                connection.rollback();
                return false;
            }

            connection.commit();
            return true;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
            return false;
    }
    	 finally {
             try {
                 connection.setAutoCommit(true);
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
         }
    	}}
    

