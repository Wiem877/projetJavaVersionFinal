package gestion;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

public class SaveButtonListener {
	 public void actionPerformed(ActionEvent e) {
         Object cinField;
		String cin = ((Object) cinField).getText().trim();
         String nom = nomField.getText().trim();
         String prenom = prenomField.getText().trim();
         String tel = telField.getText().trim();

         // Validation des champs
         if (cin.isEmpty() || nom.isEmpty() || prenom.isEmpty() || tel.isEmpty()) {
             JOptionPane.showMessageDialog(GestionClientInterface.this, "Tous les champs sont obligatoires.", "Erreur", JOptionPane.ERROR_MESSAGE);
             return;
         }

         if (!tel.matches("\\d+")) {
             JOptionPane.showMessageDialog(ClientFormApp.this, "Le numéro de téléphone doit contenir uniquement des chiffres.", "Erreur", JOptionPane.ERROR_MESSAGE);
             return;
         }

         // Ajouter le client à la liste
         String clientInfo = "CIN: " + cin + ", Nom: " + nom + ", Prénom: " + prenom + ", Téléphone: " + tel;
         clientList.add(clientInfo);

         // Mettre à jour l'affichage
         displayArea.append(clientInfo + "\n");

         // Réinitialiser les champs
         cinField.setText("");
         nomField.setText("");
         prenomField.setText("");
         telField.setText("");

         JOptionPane.showMessageDialog(GestionClientInterface.this, "Client enregistré avec succès !");
     }
 }
}
