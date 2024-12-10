package Interfaces;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GestionClients extends JFrame
{
	public GestionClients()
	{
		System.out.println("Fenêtre GestionClients initialisée");
		// Configuration de la fenêtre principale
	    setTitle("Gestion des Clients");
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
	    JLabel label1 = new JLabel("Création d'un client");
	    JButton button1 = new JButton("Creer ");
	        // Ajouter le label et le bouton au panneau
	    contentPanel.add(label1);
	    contentPanel.add(button1);
	    JLabel label2 = new JLabel("Modification d'un client");
	    JButton button2 = new JButton("Modifier ");
	        // Ajouter le label et le bouton au panneau
	    contentPanel.add(label2);
	    contentPanel.add(button2);
	    JLabel label3 = new JLabel("Consultation d'un client");
	    JButton button3 = new JButton("Consulter mes informations ");
	    contentPanel.add(label3);
	    contentPanel.add(button3);
	    JLabel label4 = new JLabel("Supprimer client");
	    JButton button4 = new JButton("Supprimer ");
	    contentPanel.add(label4);
	    JLabel label5 = new JLabel(); 
	    contentPanel.add(label5);
	    JButton button5 = new JButton("Retour ");
	    contentPanel.add(button4);
	    // Ajouter le panneau central au conteneur principal
	    mainPanel.add(contentPanel, BorderLayout.CENTER);
	    // Ajouter le panneau principal à la fenêtre
	    add(mainPanel);
	    button1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Ouvrir la nouvelle fenêtre lorsqu'on clique sur le bouton
	        	CreationClient page2 = new CreationClient(); // Classe existante dans le package
	            page2.setVisible(true);
	        }
	    });
	    button2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Ouvrir la nouvelle fenêtre lorsqu'on clique sur le bouton
	        	ModifierClientInterface page2 = new ModifierClientInterface(); // Classe existante dans le package
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
	        	SupprimerClientInterface page2 = new SupprimerClientInterface(); // Classe existante dans le package
	            page2.setVisible(true);
	        }
	    });
	    button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fermer la fenêtre actuelle
                dispose();  // Ferme la fenêtre actuelle

                // Ouvrir la fenêtre précédente
                // Assurez-vous d'instancier et d'afficher la fenêtre précédente ici
                // Par exemple :
                InterfacePrincipal pagePrecedente = new InterfacePrincipal(); // Cette classe est l'exemple de la fenêtre précédente
                pagePrecedente.setVisible(true); // Affiche la fenêtre précédente
            }
        });
	    }

public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
    	GestionClients app = new GestionClients();
        app.setVisible(true);
    });
}
}