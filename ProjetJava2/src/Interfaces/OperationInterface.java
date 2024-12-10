package Interfaces;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
	    JLabel label1 = new JLabel("Retrait d’un montant");
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
	    button2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Ouvrir la nouvelle fenêtre lorsqu'on clique sur le bouton
	        	VersementInterface nouvellePage = new VersementInterface(); // Classe existante dans le package
	            nouvellePage.setVisible(true);
	        }
	    });
	    button3.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Ouvrir la nouvelle fenêtre lorsqu'on clique sur le bouton
	        	VirementInterface nouvellePage = new VirementInterface(); // Classe existante dans le package
	            nouvellePage.setVisible(true);
	        }
	    });
	    button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fermer la fenêtre actuelle
                  // Ferme la fenêtre actuelle
                try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion", "root", "root")){
                GestionComptesInteface pagePrecedente = new GestionComptesInteface(connection); // Cette classe est l'exemple de la fenêtre précédente
                pagePrecedente.setVisible(true);
                dispose();
                }catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }}
            
        });
	}
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(() -> {
	    	OperationInterface app = new OperationInterface();
	        app.setVisible(true);
	    });
	}
}