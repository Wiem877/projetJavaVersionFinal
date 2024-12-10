package Interfaces;
import services.ClientServiceImpl;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import ClassesPrincipaux.Client;

public class ModifierClientInterface extends JFrame{
	 // Champs pour modifier les informations du client
	private JTextField cinField;
    private JTextField nameField;
    private JTextField prenomField;
    private JTextField phoneField;

    public ModifierClientInterface() {
        // Configuration de la fenêtre
        setTitle("Modifier les informations du client");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrer la fenêtre à l'écran

        // Création du panneau principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 2, 10, 10)); // GridLayout avec 4 lignes et 2 colonnes

        // Ajouter le label et les champs de texte pour chaque information
        mainPanel.add(new JLabel("Cin du client à modifier:"));
        cinField = new JTextField();
        mainPanel.add(cinField);
        mainPanel.add(new JLabel("Nom du client:"));
        nameField = new JTextField();
        mainPanel.add(nameField);

        mainPanel.add(new JLabel("Prenom du client:"));
        prenomField = new JTextField();
        mainPanel.add(prenomField);

        mainPanel.add(new JLabel("Téléphone du client:"));
        phoneField = new JTextField();
        mainPanel.add(phoneField);

        // Ajouter un bouton pour valider les modifications
        JButton button = new JButton("Modifier");
        mainPanel.add(button);
        JButton retourner = new JButton("Retour");
        mainPanel.add(retourner);
        // Ajouter un label pour afficher un message de confirmation
        JLabel statusLabel = new JLabel(" ");
        mainPanel.add(statusLabel);

        // Ajouter une action au bouton "Modifier"
        retourner.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fermer la fenêtre actuelle
                dispose();  // Ferme la fenêtre actuelle

                // Ouvrir la fenêtre précédente
                // Assurez-vous d'instancier et d'afficher la fenêtre précédente ici
                // Par exemple :
                GestionClients pagePrecedente = new GestionClients(); // Cette classe est l'exemple de la fenêtre précédente
                pagePrecedente.setVisible(true); // Affiche la fenêtre précédente
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Récupérer les informations des champs
                	ClientServiceImpl clientService = new ClientServiceImpl();
                	String cin = cinField.getText();
                    String name = nameField.getText();
                    String prenom = prenomField.getText();
                    String phone = phoneField.getText();
                    int cinn=Integer.parseInt(cin);
                    int tel=Integer.parseInt(phone);
                    // Vérifier si tous les champs sont remplis
                    if (cin.isEmpty()||name.isEmpty() || prenom.isEmpty() || phone.isEmpty()) {
                        statusLabel.setText("Tous les champs doivent être remplis.");
                        statusLabel.setForeground(Color.RED);
                    } else {
                    	Client client = new Client(cinn, name, prenom,tel);
                        // Appeler la méthode pour modifier les informations du client
                        boolean modificationReussie = clientService.modifierClient(client);
                        
                        if (modificationReussie==true) {
                            statusLabel.setText("Les informations ont été modifiées.");
                            statusLabel.setForeground(Color.GREEN);
                        } else {
                            statusLabel.setText("Échec de la modification.");
                            statusLabel.setForeground(Color.RED);
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Une erreur est survenue.");
                }
            }
        });

        // Ajouter le panneau principal à la fenêtre
        add(mainPanel);
    }
 
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> {
            // Créer et afficher la fenêtre
            ModifierClientInterface app = new ModifierClientInterface();
            app.setVisible(true);
        });
    }
  }
