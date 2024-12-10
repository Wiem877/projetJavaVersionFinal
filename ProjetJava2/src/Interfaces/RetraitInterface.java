package Interfaces;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import ClassesPrincipaux.CompteBancaire;
import services.OperationServiceImpl;

public class RetraitInterface extends JFrame
{
	private JTextField txtNumCompte;
    private JTextField txtMontant;
    private JButton btnRetirer;

    // Référence au service de compte
    private OperationServiceImpl serviceCompte= new OperationServiceImpl();

    public RetraitInterface() {
       // this.serviceCompte = serviceCompte;

        setTitle("Retrait d'argent");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));

        // Labels et champs de saisie
        add(new JLabel("Numéro de compte:"));
        txtNumCompte = new JTextField();
        add(txtNumCompte);

        add(new JLabel("Montant à retirer:"));
        txtMontant = new JTextField();
        add(txtMontant);

        // Bouton
        btnRetirer = new JButton("Retirer");
        add(btnRetirer);

        JLabel lblResult = new JLabel("");
        add(lblResult);

        // Action du bouton
        btnRetirer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numCompte = Integer.parseInt(txtNumCompte.getText());
                    float montant = Float.parseFloat(txtMontant.getText());
                    if(montant<=0) {
                    	lblResult.setText("Échec du versement : montant invalide.");
                    	return;
                	}
                    // Création d'un objet CompteBancaire
                    CompteBancaire compte = new CompteBancaire(numCompte);

                    // Appel au service
                    boolean success = serviceCompte.retrait(compte, montant);

                    if (success) {
                        lblResult.setText("Retrait effectué avec succès.");
                    } else {
                        lblResult.setText("Échec du retrait : solde insuffisant ou erreur.");
                    }
                } catch (NumberFormatException ex) {
                    lblResult.setText("Entrées invalides !");
                }
            }
        });
    }

    public static void main(String[] args) {
       
        SwingUtilities.invokeLater(() -> new RetraitInterface().setVisible(true));
    }

}
