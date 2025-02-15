package gestion;
import java.awt.BorderLayout;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class OperationInterface extends JFrame
{
	public OperationInterface()
	{
		setTitle("Operation de compte");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        // Ajouter un titre en haut
	    JLabel title = new JLabel("Bienvenue", SwingConstants.CENTER);
	    title.setFont(new Font("Arial", Font.BOLD, 18)); // Titre en gras
	    mainPanel.add(title, BorderLayout.NORTH);
	    JPanel contentPanel = new JPanel();
	    contentPanel.setLayout(new GridLayout(5, 2, 10, 10));
	    JLabel label1 = new JLabel("Retraitd’un montant");
	    JButton button1 = new JButton("Retrait");
	    contentPanel.add(label1);
	    contentPanel.add(button1);
	    JLabel label2 = new JLabel("Versement d'un montant");
	    JButton button2 = new JButton("Versement");
	        // Ajouter le label et le bouton au panneau
	    contentPanel.add(label2);
	    contentPanel.add(button2);
	    JLabel label3 = new JLabel("Virement d’un montant");
	    JButton button3 = new JButton("Virement ");
	    contentPanel.add(label3);
	    contentPanel.add(button3);
	    JLabel vide1 = new JLabel();
	    contentPanel.add(vide1);
	    JLabel vide2 = new JLabel();
	    contentPanel.add(vide2);
	    JButton button4 = new JButton("Retour ");
	    contentPanel.add(button4);
	    mainPanel.add(contentPanel, BorderLayout.CENTER);
	    add(mainPanel);
	    button1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Ouvrir la nouvelle fenêtre lorsqu'on clique sur le bouton
	            RetraitInterface nouvellePage = new RetraitInterface(); // Classe existante dans le package
	            nouvellePage.setVisible(true);
	        }
	    });
	    button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fermer la fenêtre actuelle
                dispose();  // Ferme la fenêtre actuelle

                // Ouvrir la fenêtre précédente
                // Assurez-vous d'instancier et d'afficher la fenêtre précédente ici
                // Par exemple :
                GestionComptesInteface pagePrecedente = new GestionComptesInteface(); // Cette classe est l'exemple de la fenêtre précédente
                pagePrecedente.setVisible(true); // Affiche la fenêtre précédente
            }
        });
	}
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(() -> {
	    	OperationInterface app = new OperationInterface();
	        app.setVisible(true);
	    });
	}
}