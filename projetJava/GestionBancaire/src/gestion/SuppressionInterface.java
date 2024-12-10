package gestion;
import java.awt.BorderLayout;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuppressionInterface extends JFrame {
	public SuppressionInterface()
	{
		setTitle("Suppression de Compte");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panneau principal
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Titre
        JLabel title = new JLabel("Suppression de Client", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(2, 2, 10, 10));
        JLabel numLabel = new JLabel("donner numero d'un compte");
        JTextField numField = new JTextField();
        JButton button = new JButton("Supprimer");
        JButton button2 = new JButton("Retour ");
	    formPanel.add(button2);
        formPanel.add(numLabel);
        formPanel.add(numField);
        formPanel.add(button);
        formPanel.add(button2);
        add(formPanel);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fermer la fenêtre actuelle
                dispose();  // Ferme la fenêtre actuelle

                // Ouvrir la fenêtre précédente
                // Assurez-vous d'instancier et d'afficher la fenêtre précédente ici
                // Par exemple :
                OperationInterface pagePrecedente = new OperationInterface(); // Cette classe est l'exemple de la fenêtre précédente
                pagePrecedente.setVisible(true); // Affiche la fenêtre précédente
            }
        });
	}
	}

