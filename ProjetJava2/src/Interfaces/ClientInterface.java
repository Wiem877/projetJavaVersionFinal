package Interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class ClientInterface extends JFrame{
	
	public ClientInterface()
	{
		 setTitle("Interface Client");
	        setSize(400, 300);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null); // Centrer la fenêtre à l'écran

	        // Conteneur principal
	        JPanel mainPanel = new JPanel();
	        mainPanel.setLayout(new BorderLayout());

	        // Titre
	        JLabel title = new JLabel("Bienvenue Client", SwingConstants.CENTER);
	        title.setFont(new Font("Arial", Font.BOLD, 24)); // Police et taille du titre
	        mainPanel.add(title, BorderLayout.NORTH);

	        // Panneau pour les boutons
	        JPanel buttonPanel = new JPanel();
	        buttonPanel.setLayout(new GridLayout(2, 2, 10, 10)); // 2 ligne, 2 colonnes

	        // Boutons
	        JButton button1 = new JButton("Login");
	        JButton button2 = new JButton("S'inscrire");

	        // Ajouter les boutons au panneau
	        buttonPanel.add(button1);
	        buttonPanel.add(button2);

	        // Ajouter le panneau des boutons au conteneur principal
	        mainPanel.add(buttonPanel, BorderLayout.CENTER);

	        // Ajouter le conteneur principal à la fenêtre
	        add(mainPanel);

	        // Rendre la fenêtre visible
	        setVisible(true);

	        // Ajout des gestionnaires d'événements (logique à compléter)
	        button1.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                try {
	                    // Établir une connexion
	                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion", "root", "root");
	                    
	                    // Ouvrir l'interface de login
	                    new LoginInterface(connection);
	                    
	                    // Fermer la fenêtre actuelle
	                    dispose();
	                } catch (SQLException ex) {
	                    JOptionPane.showMessageDialog(null, "Impossible de se connecter à la base de données.\nVérifiez vos paramètres de connexion.");
	                    ex.printStackTrace();
	                }
	            }
	        });
	        button2.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	CreationCompte creationCompte = new CreationCompte();
	                creationCompte.setVisible(true); // Rendre la fenêtre visible
	                dispose(); // Fermer la fenêtre actuelle
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
	        // Lancer l'interface Client
	        SwingUtilities.invokeLater(() -> new ClientInterface());
	    }
	}

