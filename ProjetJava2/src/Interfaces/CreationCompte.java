package Interfaces;
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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import ClassesPrincipaux.CompteBancaire;

import services.CompteServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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
	        JLabel title = new JLabel("Création de compte", SwingConstants.CENTER);
	        title.setFont(new Font("Arial", Font.BOLD, 18));

	        // Panneau de formulaire
	        JPanel formPanel = new JPanel();
	        formPanel.setLayout(new GridLayout(8, 2, 10, 10));
	        JLabel numLabel = new JLabel("Numero d'un compte");
	        numField = new JTextField();
	        JLabel cinLabel = new JLabel("Numéro CIN :");
	        cinField = new JTextField();
	        JLabel pwdLabel = new JLabel("mot de passe");
	        JPasswordField password= new  JPasswordField();
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
	        formPanel.add(pwdLabel);
	        formPanel.add(password);
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
	                ClientInterface  pagePrecedente = new ClientInterface();
	                pagePrecedente.setVisible(true); // Affiche la fenêtre précédente
	            }
	        });
	        button.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            try
	            {
	            	 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion", "root", "root");
		                // Récupérer les informations des champs
		            	CompteServiceImpl compteService = new CompteServiceImpl();
		                int numCompte =Integer.parseInt(numField.getText()) ;
		                int cin =Integer.parseInt(cinField.getText()) ;
		                char[] pwdChars = password.getPassword();
		                String pwd = new String(pwdChars);

		                float solde =Float.parseFloat(soldeField.getText());
		                String text = dateField.getText();
		               // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		                LocalDate date = LocalDate.parse(text);
		                CompteBancaire compte= new CompteBancaire(numCompte,cin,pwd,solde,date);
		                compteService.creerCompte(compte);
		                // passer à l'interface precedente
		                GestionCompteInterface  pagePrecedente = new GestionCompteInterface(connection);
		                pagePrecedente.setVisible(true);
		            }
	            catch (NumberFormatException ex) {
	                JOptionPane.showMessageDialog(null, "Veuillez entrer des valeurs numériques valides pour le numéro, le CIN et le solde.", "Erreur de format", JOptionPane.ERROR_MESSAGE);
	            } catch (DateTimeParseException ex) {
	                JOptionPane.showMessageDialog(null, "Veuillez entrer une date valide au format AAAA-MM-JJ.", "Erreur de format de date", JOptionPane.ERROR_MESSAGE);
	            } catch (Exception ex) {
	                JOptionPane.showMessageDialog(null, "Une erreur est survenue : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
	                ex.printStackTrace(); 
	            }
	            } });
	        
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