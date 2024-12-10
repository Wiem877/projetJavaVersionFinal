package gestion;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ModifierClientInterface extends JFrame{
	 // Champs pour modifier les informations du client
    private JTextField nameField;
    private JTextField addressField;
    private JTextField phoneField;

    public ModifierClientInterface() {
        // Configuration de la fenêtre
        setTitle("Modifier les informations du client");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrer la fenêtre à l'écran

        // Création du panneau principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 2, 10, 10)); // GridLayout avec 4 lignes et 2 colonnes

        // Ajouter le label et les champs de texte pour chaque information
        mainPanel.add(new JLabel("Nom du client:"));
        nameField = new JTextField();
        mainPanel.add(nameField);

        mainPanel.add(new JLabel("Prenom du client:"));
        addressField = new JTextField();
        mainPanel.add(addressField);

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
                // Récupérer les informations des champs
                String name = nameField.getText();
                String address = addressField.getText();
                String phone = phoneField.getText();

                // Vérifier si tous les champs sont remplis
                if (name.isEmpty() || address.isEmpty() || phone.isEmpty()) {
                    statusLabel.setText("Tous les champs doivent être remplis.");
                    statusLabel.setForeground(Color.RED);
                } else {
                    // Effectuer la modification (ici, on peut imaginer une sauvegarde dans une base de données ou autre)
                    statusLabel.setText("Les informations ont été modifiées.");
                    statusLabel.setForeground(Color.GREEN);

                    // Ici, vous pourriez effectuer des opérations comme enregistrer dans une base de données
                    // ou mettre à jour un modèle de client.
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
