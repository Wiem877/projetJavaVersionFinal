package Interfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import ClassesPrincipaux.CompteBancaire;
import services.CompteServiceImpl;

public class ConsulterCompteInterface extends JFrame{
	private JTextField numCompteField;
    private JTextArea resultArea;
    private JButton consulterButton;

    public ConsulterCompteInterface() {
        setTitle("Consulter Compte");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panneau principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Titre
        JLabel title = new JLabel("Consulter un compte bancaire", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(title, BorderLayout.NORTH);

        // Panneau de formulaire
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(2, 2, 10, 10));

        JLabel numCompteLabel = new JLabel("Numéro de Compte : ");
        numCompteField = new JTextField();
        consulterButton = new JButton("Consulter");

        formPanel.add(numCompteLabel);
        formPanel.add(numCompteField);
        formPanel.add(consulterButton);
        panel.add(formPanel, BorderLayout.CENTER);

        // Panneau d'affichage des résultats
        
        resultArea = new JTextArea(); 
        resultArea.setPreferredSize(new Dimension(300, 200));// creer une nouvelle zone de texte
        resultArea.setEditable(false); // la zone de texte non modifiable
        resultArea.setLineWrap(true); // retour automatique à la ligne  
        resultArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        panel.add(scrollPane, BorderLayout.SOUTH);

        // Ajouter le panneau principal à la fenêtre
        add(panel);

        // Ajouter le comportement du bouton
        consulterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Appeler la méthode pour consulter le compte
                int numCompte = Integer.parseInt(numCompteField.getText());
               // CompteBancaire compte = new CompteBancaire(numCompte);
                CompteServiceImpl service=new CompteServiceImpl();
                

                // Afficher les informations du compte
                CompteBancaire compte =service.consulterCompte(numCompte);
                if (compte != null) {
                    resultArea.setText("Numéro de Compte: " + compte.getNumCompte() + "\n" +
                            "Numéro CIN: " + compte.getCinClient() + "\n" +
                            "Solde: " + compte.getSolde() +"password:"+compte.getPassword() + "\n" +
                            "Date d'ouverture: " + compte.getDateOuverture());
                } else {
                    resultArea.setText("Compte non trouvé.");
                }
            }
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ConsulterCompteInterface frame = new ConsulterCompteInterface();
                frame.setVisible(true);
            }
        });
    }
}
