package gestion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class CreationCompte extends JFrame{
	 private JTextField cinField;
	    private JTextField numField;
	    private JTextField soldeField;
	    private JTextField dateField;
	    public CreationCompte()
	    {
	    	setTitle("Création de Compte");
	        setSize(500, 400);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);

	        // Panneau principal
	        JPanel mainPanel = new JPanel(new BorderLayout());

	        // Titre
	        JLabel title = new JLabel("Création de Client", SwingConstants.CENTER);
	        title.setFont(new Font("Arial", Font.BOLD, 18));

	        // Panneau de formulaire
	        JPanel formPanel = new JPanel();
	        formPanel.setLayout(new GridLayout(7, 2, 10, 10));
	        JLabel numLabel = new JLabel("Numero d'un compte");
	        numField = new JTextField();
	        JLabel cinLabel = new JLabel("Numéro CIN :");
	        cinField = new JTextField();
	        JLabel soldeLabel = new JLabel("solde");
	        soldeField = new JTextField();
	        JLabel dateLabel = new JLabel("date ouverture");
	        dateField = new JTextField();
	        JButton button = new JButton("Enregistrer");
	        JButton retourner = new JButton("Retour");
	        formPanel.add(numLabel);
	        formPanel.add(numField);
	        formPanel.add(cinLabel);
	        formPanel.add(cinField);
	        formPanel.add(soldeLabel);
	        formPanel.add(soldeField);
	        formPanel.add(dateLabel);
	        formPanel.add(dateField);
	        formPanel.add(button);
	        formPanel.add(retourner);
	        // Panneau d'affichage
	        JTextArea displayArea = new JTextArea();
	        displayArea.setEditable(false);
	        JScrollPane scrollPane = new JScrollPane(displayArea);
	        // Ajout des composants au panneau principal
	        mainPanel.add(title, BorderLayout.NORTH);
	        mainPanel.add(formPanel, BorderLayout.CENTER);
	        mainPanel.add(scrollPane, BorderLayout.SOUTH);
	        JLabel statusLabel = new JLabel(" ");
	        mainPanel.add(statusLabel);
	        retourner.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                dispose();  // Ferme la fenêtre actuelle

	                // Ouvrir la fenêtre précédente
	                // Assurez-vous d'instancier et d'afficher la fenêtre précédente ici
	                GestionComptesInteface  pagePrecedente = new GestionComptesInteface();
	                pagePrecedente.setVisible(true); // Affiche la fenêtre précédente
	            }
	        });
	        button.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Récupérer les informations des champs
	                String cin = cinField.getText();
	                String num = numField.getText();
	                String solde = soldeField.getText();
	                String date = dateField.getText();
	                CreerCompte creerCompte = new CreerCompte();
	                CreerCompte.insererCompte(cin,num, solde, date);
	            }
	        });
	        // Ajouter le panneau principal à la fenêtre
	        //add(formPanel);
	        add(formPanel);
	    }
	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	        	CreationCompte app = new CreationCompte();
	            app.setVisible(true);
	        });
	    }


	    }
