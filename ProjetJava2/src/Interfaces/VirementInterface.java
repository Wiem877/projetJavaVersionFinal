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

public class VirementInterface extends JFrame{
	private JTextField txtNumCompteSource;
	private JTextField txtNumCompteDest;
    private JTextField txtMontant;
    private JButton btnVirer;

    // Référence au service de compte
    private OperationServiceImpl serviceCompte= new OperationServiceImpl();

    public VirementInterface() {
       // this.serviceCompte = serviceCompte;

        setTitle("Transferer d'argent");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));

        // Labels et champs de saisie
        add(new JLabel("Numéro de votre compte:"));
        txtNumCompteSource = new JTextField();
        add(txtNumCompteSource);
        add(new JLabel("Numéro de compte destinataire:"));
        txtNumCompteDest = new JTextField();
        add(txtNumCompteDest);
        
        add(new JLabel("Montant à transféré:"));
        txtMontant = new JTextField();
        add(txtMontant);

        // Bouton
        btnVirer = new JButton("Virer");
        add(btnVirer);

        JLabel lblResult = new JLabel("");
        add(lblResult);

        // Action du bouton
        btnVirer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numCompte = Integer.parseInt(txtNumCompteSource.getText());
                    int numCompteDes = Integer.parseInt(txtNumCompteDest.getText());
                    float montant = Float.parseFloat(txtMontant.getText());

                    
                    if(montant<=0) {
                    	lblResult.setText("Échec du versement : montant invalide.");
                    	return;
                	}
                 // Création d'un objet CompteBancaire
                    CompteBancaire compte = new CompteBancaire(numCompte);
                    CompteBancaire compteDest = new CompteBancaire(numCompteDes);
                    // Appel au service
                    boolean success = serviceCompte.virement(compte,compteDest, montant);

                    if (success) {
                        lblResult.setText("Virement effectué avec succès.");
                    }
                } catch (NumberFormatException ex) {
                    lblResult.setText("Entrées invalides !");
                }
            }
        });
    }

    public static void main(String[] args) {
       
        SwingUtilities.invokeLater(() -> new VirementInterface().setVisible(true));
    }


}
