package Interfaces;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class GestionCompteInterface extends JFrame{
	public GestionCompteInterface(Connection connection)
	{
		// Configuration de la fenêtre principale
	    setTitle("Gestion des Compte");
	    setSize(400, 300);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null); // Centrer la fenêtre à l'écran

	    // Configuration du conteneur principal
	    JPanel mainPanel = new JPanel();
	    mainPanel.setLayout(new BorderLayout()); // Utilisation de BorderLayout pour structurer l'interface

	    // Ajouter un titre en haut
	    JLabel title = new JLabel("Bienvenue dans la gestion de compte", SwingConstants.CENTER);
	    title.setFont(new Font("Arial", Font.BOLD, 18)); // Titre en gras
	    mainPanel.add(title, BorderLayout.NORTH);

	    // Ajouter les labels et boutons dans un panneau central
	    JPanel contentPanel = new JPanel();
	    contentPanel.setLayout(new GridLayout(6, 2, 10, 10)); // Grille avec 3 lignes, 2 colonnes, et espacement

	    // Ajouter les lignes de labels et boutons
	    JLabel label1 = new JLabel("Gerer mon compte bancaire");
	    JButton button1 = new JButton("gerer Compte");
	    JLabel label2 = new JLabel("faire une Operation");
	    JButton button2 = new JButton("operation");
	    contentPanel.add(label1);
	    contentPanel.add(button1);
	    contentPanel.add(label2);
	    contentPanel.add(button2);
	    mainPanel.add(contentPanel, BorderLayout.CENTER);
	    // Ajouter le panneau principal à la fenêtre
	    add(mainPanel);
	    button1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Ouvrir la nouvelle fenêtre lorsqu'on clique sur le bouton
	        	ServicesCompteInterface page2 = new ServicesCompteInterface(); // Classe existante dans le package
	            page2.setVisible(true);
	        }
	    });
	    button2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Ouvrir la nouvelle fenêtre lorsqu'on clique sur le bouton
	        	OperationInterface page2 = new OperationInterface(); // Classe existante dans le package
	            page2.setVisible(true);
	        }
	    });
}
	public static void main(String[] args) {
		Connection connection = null; // Initialisation de la connexion

	    try {
	        // Tentative de connexion à la base de données
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion", "root", "root");
	    } catch (SQLException ex) {
	        // En cas d'erreur, afficher un message et arrêter le programme
	        JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données : " + ex.getMessage());
	        ex.printStackTrace();
	        System.exit(1); // Quitter le programme si la connexion échoue
	    }
	    Connection finalConnection = connection;
	    SwingUtilities.invokeLater(() -> {
	    	GestionCompteInterface app = new GestionCompteInterface(finalConnection);
	        app.setVisible(true);
	    });
	}
	}
