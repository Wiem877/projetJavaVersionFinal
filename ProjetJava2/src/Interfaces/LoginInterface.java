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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import ClassesPrincipaux.User;

public class LoginInterface extends JFrame{
	private Connection connection;
	// Ajoutez une connexion à la base de données

    public LoginInterface(Connection connection) {
        this.connection = connection; // Initialisez la connexion

        // Configuration de la fenêtre principale
        setTitle("Login");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrer la fenêtre à l'écran

        // Conteneur principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Titre
        JLabel title = new JLabel("Connexion", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(title, BorderLayout.NORTH);

        // Panneau pour les champs de connexion
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2, 10, 10));

        // Labels et champs de texte
        JLabel userLabel = new JLabel("Numero compte");
        JTextField numCompteField = new JTextField();
        JLabel passwordLabel = new JLabel("Mot de passe:");
        JPasswordField passwordField = new JPasswordField();

        formPanel.add(userLabel);
        formPanel.add(numCompteField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        // Bouton de connexion
        JButton loginButton = new JButton("Se connecter");
        mainPanel.add(loginButton, BorderLayout.SOUTH);

        // Ajouter le panneau principal à la fenêtre
        add(mainPanel);

        // Action du bouton de connexion
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numCompte = Integer.parseInt(numCompteField.getText());
                String password = new String(passwordField.getPassword());

                // Vérifier les informations de connexion
                try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion", "root", "root"))
                {
                	User user = new User(numCompte,password);
                    if (user.authentifier(numCompte, password, connection)) {
                        JOptionPane.showMessageDialog(null, "Connexion réussie !");
                        
                        // Lancer une autre interface après la connexion
                        GestionCompteInterface  pagePrecedente = new GestionCompteInterface(connection);
                        pagePrecedente.setVisible(true);
                     // Fermer la fenêtre de connexion
                        dispose(); 
                    } else {
                        JOptionPane.showMessageDialog(null, "Nom d'utilisateur ou mot de passe incorrect.");
                    }
                }catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }}
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        // Initialisez une connexion à la base de données
       
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion", "root", "root")) {
            SwingUtilities.invokeLater(() -> new LoginInterface(connection));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données.");
            e.printStackTrace();
        }
}}
