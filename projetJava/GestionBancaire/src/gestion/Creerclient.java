package gestion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Creerclient {
	public static void insererClient(String cin,String nom, String prenom, String tel) {
        String query = "INSERT INTO client (nom, prenom, email) VALUES (?, ?, ?,?)";

        try (Connection conn = Connecter.obtenirConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)) {
        	int cinn = Integer.parseInt(cin);
        	int tell=Integer.parseInt(tel);
        	pstmt.setInt(1,cinn);
            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            pstmt.setInt(3, tell);
            pstmt.executeUpdate();
            System.out.println("Client inséré avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
