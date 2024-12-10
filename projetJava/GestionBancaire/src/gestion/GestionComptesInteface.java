package gestion;
import java.awt.BorderLayout;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionComptesInteface extends JFrame
{
	public GestionComptesInteface()
	{
		setTitle("Gestion des comptes");
	    setSize(400, 300);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null); // Centrer la fenêtre à l'écran

	    // Configuration du conteneur principal
	    JPanel mainPanel = new JPanel();
	    mainPanel.setLayout(new BorderLayout()); // Utilisation de BorderLayout pour structurer l'interface

	    // Ajouter un titre en haut
	    JLabel title = new JLabel("Bienvenue dans la gestion des comptes", SwingConstants.CENTER);
	    title.setFont(new Font("Arial", Font.BOLD, 18)); // Titre en gras
	    mainPanel.add(title, BorderLayout.NORTH);
	    JPanel contentPanel = new JPanel();
	    contentPanel.setLayout(new GridLayout(6, 2, 10, 10));
	    JLabel label1 = new JLabel("Création d'un compte");
	    JButton button1 = new JButton("Creer un compte ");
	        // Ajouter le label et le bouton au panneau
	    contentPanel.add(label1);
	    contentPanel.add(button1);
	    JLabel label2 = new JLabel("Modification d'un compte");
	    JButton button2 = new JButton("Modifier un compte");
	        // Ajouter le label et le bouton au panneau
	    contentPanel.add(label2);
	    contentPanel.add(button2);
	    JLabel label3 = new JLabel("Suppression un compte");
	    JButton button3 = new JButton("Supprimer ");
	    contentPanel.add(label3);
	    contentPanel.add(button3);
	    JLabel label5 = new JLabel("faire une peration");
	    contentPanel.add(label5);
	    JButton button5 = new JButton("operation ");
	    contentPanel.add(button5);
	    JLabel vide1 = new JLabel(); // label vide
	    contentPanel.add(vide1);
	    JLabel vide2 = new JLabel(); // label vide
	    contentPanel.add(vide2);
	    JButton button4 = new JButton("Retour ");
	    contentPanel.add(button4);
	    // Ajouter le panneau central au conteneur principal
	    mainPanel.add(contentPanel, BorderLayout.CENTER);
	    // Ajouter le panneau principal à la fenêtre
	    add(mainPanel);
	    button1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Ouvrir la nouvelle fenêtre lorsqu'on clique sur le bouton
	        	CreationCompte nouvellePage = new CreationCompte(); // Classe existante dans le package
	            nouvellePage.setVisible(true);
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
	        	SuppressionInterface page2 = new SuppressionInterface(); // Classe existante dans le package
	            page2.setVisible(true);
	        }
	    });
	    button4.addActionListener(new ActionListener() {
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
	    button5.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Ouvrir la nouvelle fenêtre lorsqu'on clique sur le bouton
	        	OperationInterface nouvellePage = new OperationInterface(); // Classe existante dans le package
	            nouvellePage.setVisible(true);
	        }
	    });
	    }

public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
    	GestionComptesInteface app = new GestionComptesInteface();
        app.setVisible(true);
    });
}}
