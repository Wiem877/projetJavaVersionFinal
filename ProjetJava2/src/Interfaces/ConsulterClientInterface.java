package Interfaces;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.*;
public class ConsulterClientInterface extends JFrame{
	 public ConsulterClientInterface() {
	        setTitle("Afficher les données");
	        setSize(600, 400);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        // Requête SQL pour récupérer les données
	       // preparer la requete
	        String query = "SELECT * FROM client";
	        try {
	            // Récupérer les colonnes et les lignes
	            Vector lignes = ConsulterClient.recupererLigne(query);
	            Vector colonnes = ConsulterClient.getTableColumns(query);

	            // Créer la JTable avec les données et les colonnes
	            JTable table = new JTable(lignes, colonnes);

	            // Ajouter la JTable dans un JScrollPane pour l'affichage défilable
	            JScrollPane scrollPane = new JScrollPane(table);
	            add(scrollPane, BorderLayout.CENTER);
	        } catch (Exception e) {
	            e.printStackTrace();
	            
	            JOptionPane.showMessageDialog(this, "Erreur : " + e.getMessage());
	        }
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	        	ConsulterClientInterface frame = new ConsulterClientInterface();
	            frame.setVisible(true);
	        });
	    }
	}