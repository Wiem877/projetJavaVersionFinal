package gestion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class InterfacePrincipal extends JFrame {
	public InterfacePrincipal()
	{
		// Configuration de la fenêtre principale
        setTitle("Gestion d'une banque");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrer la fenêtre à l'écran
        // Configuration du conteneur principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout()); // Utiliser BorderLayout pour gérer les sections

        // Ajouter un titre centré en haut
        JLabel title = new JLabel("Gestion bancaire", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24)); // Police et taille du titre
        mainPanel.add(title, BorderLayout.NORTH);
        // Ajouter un panneau pour les labels et boutons
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(2, 2, 10, 10)); // Grille 2x2 avec des espacements

        // Ajouter deux labels
        JLabel label1 = new JLabel("Gestion des clients");
        JLabel label2 = new JLabel("Gestions des comptes");
        // Ajouter deux boutons
        JButton button1 = new JButton("Gerer mes informations");
        JButton button2 = new JButton("Gerer mon compte");

        // Ajouter les éléments au panneau de contenu
        contentPanel.add(label1);
        contentPanel.add(button1);
        contentPanel.add(label2);
        contentPanel.add(button2);

        // Ajouter le panneau de contenu au centre
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Ajouter le conteneur principal à la fenêtre
        add(mainPanel);

        setVisible(true); // Rendre la fenêtre visible
	// Ajouter un ActionListener au bouton
    button1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Ouvrir la nouvelle fenêtre lorsqu'on clique sur le bouton
            GestionClients nouvellePage = new GestionClients(); // Classe existante dans le package
            nouvellePage.setVisible(true);
        }
    });
    button2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Ouvrir la nouvelle fenêtre lorsqu'on clique sur le bouton
        	GestionComptesInteface nouvellePage = new GestionComptesInteface (); // Classe existante dans le package
            nouvellePage.setVisible(true);
        }
    });
    }
	public static void main(String[] args) {
        SwingUtilities.invokeLater(InterfacePrincipal::new);
    }// Configuration de la fenêtre principale
}
