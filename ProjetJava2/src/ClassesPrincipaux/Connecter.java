package ClassesPrincipaux;
import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class Connecter {
	
	
	
	public static Connection obtenirConnection()
	{
		Connection c= null;
		try
		{
			
			String url = "jdbc:mysql://localhost:3306/gestion";
		    String user = "root";
		    String password = "root";
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection(url,user,password);
			System.out.println("connection se fait avec succes");
		}
		catch(ClassNotFoundException e)
		{
			System.err.println(e);
		}
		catch(SQLException es)
		{
			System.err.println(es);
		}
		return c;
		
	}
	public static void main(String[] args) {
        Connection c = Connecter.obtenirConnection();
        if (c != null) {
            System.out.println("Connexion réussie !");
        } else {
            System.out.println("Connexion échouée.");
        }
    }
}
