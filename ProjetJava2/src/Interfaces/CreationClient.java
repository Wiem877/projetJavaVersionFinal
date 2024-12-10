package Interfaces;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import ClassesPrincipaux.Client;
import services.ClientServiceImpl;

public class CreationClient extends JFrame{
	private JTextField cinField;
    private JTextField nomField;
    private JTextField prenomField;
    private JTextField telField;
	ClientServiceImpl clientService = new ClientServiceImpl(); 
	private JLabel statusLabel;
	public CreationClient()
	{
		
		setTitle("Ajouter un Client");
	    setSize(400, 300);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(new GridLayout(6, 2, 10, 10));

	    // Labels et champs de texte
	    add(new JLabel("CIN :"));
	    cinField = new JTextField();
	    add(cinField);

	    add(new JLabel("Nom :"));
	    nomField = new JTextField();
	    add(nomField);

	    add(new JLabel("Prénom :"));
	    prenomField = new JTextField();
	    add(prenomField);

	    add(new JLabel("Téléphone :"));
	    telField = new JTextField();
	    add(telField);

	    // Bouton pour soumettre
	    JButton submitButton = new JButton("Ajouter Client");
	    add(submitButton);

	    // Espace vide pour aligner les éléments
	    add(new JLabel());
	    
	    // Gestionnaire d'événements
	    submitButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	ajouterClient();
	        }
	    });
	}

private void ajouterClient() {
    try {
		int cin = Integer.parseInt(cinField.getText());
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        int telephone = Integer.parseInt(telField.getText());

        // Validation des champs
        if (nom.isEmpty() || prenom.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tous les champs sont obligatoires.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Création d'un objet Client
        Client client = new Client((int)cin, nom, prenom,(int) telephone);

        // Appel au service pour enregistrer le client
        clientService.insererClient(client);

        JOptionPane.showMessageDialog(this, "Client ajouté avec succès !");
        
        // Réinitialisation des champs
        cinField.setText("");
        nomField.setText("");
        prenomField.setText("");
        telField.setText("");
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "CIN doit être un nombre.", "Erreur", JOptionPane.ERROR_MESSAGE);
    } 
}

public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        new CreationClient().setVisible(true);
    });
}
}

