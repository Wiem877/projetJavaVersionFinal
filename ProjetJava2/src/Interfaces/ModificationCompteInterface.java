package Interfaces;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import ClassesPrincipaux.CompteBancaire;
import services.CompteServiceImpl;

public class ModificationCompteInterface extends JFrame{
	private JTextField numCompteField;
    private JPasswordField oldPasswordField;
    private JPasswordField newPasswordField;
    private JButton modifierButton;
    
    // Constructeur de l'interface graphique
    public ModificationCompteInterface() {
        setTitle("Modifier le mot de passe");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Création des composants de l'interface
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel numCompteLabel = new JLabel("Numéro de compte :");
        numCompteField = new JTextField();
        
        JLabel oldPasswordLabel = new JLabel("Mot de passe actuel :");
        oldPasswordField = new JPasswordField();
        
        JLabel newPasswordLabel = new JLabel("Nouveau mot de passe :");
        newPasswordField = new JPasswordField();
        
        modifierButton = new JButton("Modifier");
        
        // Ajout des composants au panneau
        panel.add(numCompteLabel);
        panel.add(numCompteField);
        panel.add(oldPasswordLabel);
        panel.add(oldPasswordField);
        panel.add(newPasswordLabel);
        panel.add(newPasswordField);
        panel.add(modifierButton);
        
        // Ajout du panneau au JFrame
        add(panel);
        
        // Action pour le bouton "Modifier"
        modifierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Récupérer les données saisies
                    int numCompte = Integer.parseInt(numCompteField.getText());
                    String oldPassword = new String(oldPasswordField.getPassword());
                    String newPassword = new String(newPasswordField.getPassword());
                    
                    // Vérification du mot de passe actuel
                    if (verifierMotDePasse(numCompte, oldPassword)) {
                        // Créer un objet CompteBancaire avec le nouveau mot de passe
                        CompteBancaire compte = new CompteBancaire(numCompte, newPassword);
                        CompteServiceImpl service=new CompteServiceImpl();// instancier la classe
                        service.modifierCompte(compte);
                        JOptionPane.showMessageDialog(null, "Mot de passe modifié avec succès.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Le mot de passe actuel est incorrect.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erreur : " + ex.getMessage());
                }
            }
        });
    }
    public boolean verifierMotDePasse(int numCompte, String oldPassword) {
        String query = "SELECT password FROM compte WHERE numCompte = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion", "root", "root");
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, numCompte);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String dbPassword = rs.getString("password");
                return dbPassword.equals(oldPassword); // Comparaison des mots de passe
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Retourne false si l'utilisateur n'existe pas ou si le mot de passe ne correspond pas
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	ModificationCompteInterface frame = new ModificationCompteInterface();
                frame.setVisible(true);
            }
        });
    }
}

