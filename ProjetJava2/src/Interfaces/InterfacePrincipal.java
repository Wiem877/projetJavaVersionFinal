package Interfaces;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
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

public class InterfacePrincipal extends JFrame{
	public InterfacePrincipal()
	{
		setTitle("Bienvenu dans le gestion d'une banque");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrer la fenêtre à l'écran
        // Configuration du conteneur principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
     // Titre
        JLabel title = new JLabel("Gestion bancaire", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24)); // Police et taille du titre
        mainPanel.add(title, BorderLayout.NORTH);
        // Ajouter un panneau pour les labels et boutons
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(2, 2, 10, 10));
        JLabel label1= new JLabel("Je suis un client");
        JLabel label2 = new JLabel("Je suis un Admin");
        // Ajouter deux boutons
        JButton button1 = new JButton("client");
        JButton button2 = new JButton("admin");
        contentPanel.add(label1);
        contentPanel.add(button1);
        contentPanel.add(label2);
        contentPanel.add(button2);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Ajouter le conteneur principal à la fenêtre
        add(mainPanel);
        setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Afficher l'interface client
                new ClientInterface();
                dispose(); // Ferme la fenêtre principale
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
                    // Établir une connexion
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion", "root", "root");
                    
                    // Ouvrir l'interface de login
                    new LoginAdminInterface(connection);
                    
                    // Fermer la fenêtre actuelle
                    dispose();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Impossible de se connecter à la base de données.\nVérifiez vos paramètres de connexion.");
                    ex.printStackTrace();
                }
            }
            
        });
	}
	public static void main(String[] args) {
        // Lancer l'interface
        SwingUtilities.invokeLater(() -> new InterfacePrincipal());
    }
}
