package ClassesPrincipaux;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
	private int numCompte;
    private String password;
	  public boolean authentifier(int numCompte, String password, Connection connection)
	    {
	    	 boolean isAuthenticated = false;

	         String query = "SELECT * FROM compte WHERE numCompte = ? AND password = ?";
	         try (PreparedStatement statement = connection.prepareStatement(query)) {
	             statement.setInt(1, numCompte);
	             statement.setString(2, password); // Assurez-vous que le mot de passe est déjà haché si nécessaire

	             ResultSet resultSet = statement.executeQuery();
	             if (resultSet.next()) {
	                 // Si un résultat est trouvé, l'utilisateur est authentifié
	                 isAuthenticated = true;
	             }
	         } catch (SQLException e) {
	             e.printStackTrace();
	         }

	         return isAuthenticated;
	     }
	  public User(int numCompte,String password)
	  {
		  this.numCompte=numCompte;
		  this.password=password;
	  }
	    }


