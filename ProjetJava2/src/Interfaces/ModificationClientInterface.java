package Interfaces;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import ClassesPrincipaux.Client;
import services.ClientService;
import services.ClientServiceImpl;

public class ModificationClientInterface extends JFrame{
	private JTextField txtCIN;
    private JTextField txtNom;
    private JTextField txtPrenom;
    private JTextField txtTelephone;
    private JButton btnRechercher;
    private JButton btnModifier;

    // Service de gestion des clients
    private ClientService clientService;

    public ModificationClientInterface() {
        // Initialiser le service
        clientService = new ClientServiceImpl();// on utilise le polymorphisme

        // Configurer la fenêtre
        setTitle("Modifier un Client");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 10, 10));

        // Ajouter les champs pour le CIN (recherche)
        add(new JLabel("CIN :"));
        txtCIN = new JTextField();
        add(txtCIN);

        btnRechercher = new JButton("Rechercher");
        add(btnRechercher);
        add(new JLabel()); // Espace vide

        // Ajouter les champs pour modifier les informations du client
        add(new JLabel("Nom :"));
        txtNom = new JTextField();
        txtNom.setEnabled(false); // Désactivé tant qu'aucun client n'est trouvé
        add(txtNom);

        add(new JLabel("Prénom :"));
        txtPrenom = new JTextField();
        txtPrenom.setEnabled(false);
        add(txtPrenom);

        add(new JLabel("Téléphone :"));
        txtTelephone = new JTextField();
        txtTelephone.setEnabled(false);
        add(txtTelephone);

        // Bouton pour modifier le client
        btnModifier = new JButton("Modifier");
        btnModifier.setEnabled(false); // Désactivé tant qu'aucun client n'est trouvé
        add(btnModifier);

        // Ajouter un espace vide
        add(new JLabel());

        // ActionListener pour le bouton Rechercher
        btnRechercher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rechercherClient();
            }
        });

        // ActionListener pour le bouton Modifier
        btnModifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifierClient();
            }
        });
    }

    private void rechercherClient() {
        try {
            // Récupérer le CIN
            int cin = Integer.parseInt(txtCIN.getText());
            // Rechercher le client
            Client client = clientService.consulterClient(cin);

            if (client != null) {
                // Afficher les informations du client dans les champs
                txtNom.setText(client.getNom());
                txtPrenom.setText(client.getPrenom());
                txtTelephone.setText(String.valueOf(client.getTel()));

                // Activer les champs et le bouton Modifier
                txtNom.setEnabled(true);
                txtPrenom.setEnabled(true);
                txtTelephone.setEnabled(true);
                btnModifier.setEnabled(true);

                JOptionPane.showMessageDialog(this, "Client trouvé !");
            } else {
                JOptionPane.showMessageDialog(this, "Client introuvable.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un CIN valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erreur : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void modifierClient() {
        try {
            // Récupérer les nouvelles données du client
            int cin = Integer.parseInt(txtCIN.getText());
            String nom = txtNom.getText();
            String prenom = txtPrenom.getText();
            int telephone = Integer.parseInt(txtTelephone.getText());

            // Créer un objet Client avec les nouvelles données
            Client client = new Client(cin, nom, prenom, telephone);

            // Modifier le client via le service
            clientService.modifierClient(client);

            // Afficher un message de confirmation
            JOptionPane.showMessageDialog(this, "Client modifié avec succès !");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erreur : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ModificationClientInterface().setVisible(true);
        });
    }
}
