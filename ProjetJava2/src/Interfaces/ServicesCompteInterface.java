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

public class ServicesCompteInterface extends JFrame{
	public ServicesCompteInterface()
	{
		// Configuration de la fenêtre principale
	    setTitle("Gestion des Comptes");
	    setSize(400, 300);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null); // Centrer la fenêtre à l'écran

	    // Configuration du conteneur principal
	    JPanel mainPanel = new JPanel();
	    mainPanel.setLayout(new BorderLayout()); // Utilisation de BorderLayout pour structurer l'interface

	    // Ajouter un titre en haut
	    JLabel title = new JLabel("Bienvenue dans la gestion des clients", SwingConstants.CENTER);
	    title.setFont(new Font("Arial", Font.BOLD, 18)); // Titre en gras
	    mainPanel.add(title, BorderLayout.NORTH);

	    // Ajouter les labels et boutons dans un panneau central
	    JPanel contentPanel = new JPanel();
	    contentPanel.setLayout(new GridLayout(6, 2, 10, 10)); // Grille avec 3 lignes, 2 colonnes, et espacement

	    // Ajouter les lignes de labels et boutons
	    JLabel label1 = new JLabel("Modification d'un client");
	    JButton button1 = new JButton("Modifier ");
	        // Ajouter le label et le bouton au panneau
	    contentPanel.add(label1);
	    contentPanel.add(button1);
	   
	        // Ajouter le label et le bouton au panneau
	    JLabel label3 = new JLabel("Consultation d'un compte");
	    JButton button3 = new JButton("Consulter mes informations ");
	    contentPanel.add(label3);
	    contentPanel.add(button3);
	    JLabel label4 = new JLabel("Supprimer compte");
	    JButton button4 = new JButton("Supprimer ");
	    contentPanel.add(label4);
	    contentPanel.add(button4);
	    JButton button5 = new JButton("Retour ");
	    contentPanel.add(button5);
	    // Ajouter le panneau central au conteneur principal
	    mainPanel.add(contentPanel, BorderLayout.CENTER);
	    // Ajouter le panneau principal à la fenêtre
	    add(mainPanel);
	    button1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Ouvrir la nouvelle fenêtre lorsqu'on clique sur le bouton
	        	ModificationCompteInterface page2 = new ModificationCompteInterface(); // Classe existante dans le package
	            page2.setVisible(true);
	        }
	    });
	    button3.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Ouvrir la nouvelle fenêtre lorsqu'on clique sur le bouton
	        	ConsulterClientInterface page2 = new ConsulterClientInterface(); // Classe existante dans le package
	            page2.setVisible(true);
	        }
	    });
	    button4.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Ouvrir la nouvelle fenêtre lorsqu'on clique sur le bouton
	        	SupprimerCompte page2 = new SupprimerCompte(); // Classe existante dans le package
	            page2.setVisible(true);
	        }
	    });
	    button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fermer la fenêtre actuelle
                  // Ferme la fenêtre actuelle

                // Ouvrir la fenêtre précédente
                try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion", "root", "root"))
                {
                	GestionCompteInterface pagePrecedente = new GestionCompteInterface(connection); // Cette classe est l'exemple de la fenêtre précédente
                    pagePrecedente.setVisible(true);
                    dispose();
                }catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }}
        });
	    }

public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
    	ServicesCompteInterface app = new ServicesCompteInterface();
        app.setVisible(true);
    });
}
}
