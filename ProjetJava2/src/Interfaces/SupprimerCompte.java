package Interfaces;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import services.CompteServiceImpl;

public class SupprimerCompte extends JFrame{
	private JTextField numCompteField;
	private JButton suppButton;
	 public SupprimerCompte() {
	        setTitle("Supprimer mon compte");
	        setSize(400, 300);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        // Création des composants de l'interface
	        JPanel panel = new JPanel();
	        panel.setLayout(new GridLayout(4, 2, 10, 10));

	        JLabel numCompteLabel = new JLabel("Numéro de compte :");
	        numCompteField = new JTextField();
	        suppButton = new JButton("Supprimer");
	        panel.add(numCompteLabel);
	        panel.add(numCompteField);
	        panel.add(suppButton);
	        add(panel);
	        suppButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	 
					try {
	                    // Récupérer le numéro de compte depuis le champ de texte
	                    int numCompte = Integer.parseInt(numCompteField.getText());
	                    CompteServiceImpl service = new CompteServiceImpl();

	                    // Vérifier si le compte existe
	                    

	                    // Supprimer le compte
	                    if (service.supprimerCompte(numCompte)) {
	                        JOptionPane.showMessageDialog(null, "Compte supprimé avec succès.");
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Aucun compte trouvé avec ce numéro.");
	                    }
	                    SupprimerCompte.this.dispose();

	                    // Afficher la fenêtre principale (FenetrePrincipale)
	                    InterfacePrincipal principale = new InterfacePrincipal();
	                    principale.setVisible(true);
	                    
	                } catch (NumberFormatException ex) {
	                	JOptionPane.showMessageDialog(null,"Veuillez entrer un numéro de compte valide.");
	                    //resultArea.setText("Veuillez entrer un numéro de compte valide.");
	                } catch (Exception ex) {
	                	JOptionPane.showMessageDialog(null,"Erreur :");
	      
	                }
	            }
	        });
}
	 public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	            	SupprimerCompte frame = new SupprimerCompte();
	                frame.setVisible(true);
	            }
	        });
	    }
	}
	 
