package gestion;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class RetraitInterface extends JFrame{
	public RetraitInterface()
	{
		
		setTitle("Retrait ");
	    setSize(400, 300);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	    JPanel mainPanel = new JPanel();
	    mainPanel.setLayout(new BorderLayout());
	    JLabel mLabel = new JLabel("donner le montant à retirer");
        JTextField montant = new JTextField();
        JLabel title = new JLabel("Retrait montant", SwingConstants.CENTER);
	    title.setFont(new Font("Arial", Font.BOLD, 18)); // Titre en gras
	    mainPanel.add(title, BorderLayout.NORTH);
	    JPanel contentPanel = new JPanel();
	    contentPanel.setLayout(new GridLayout(2, 2, 5,5));
	    JButton button = new JButton("Valider");
	    contentPanel.add(mLabel);
	    contentPanel.add(montant);
	    contentPanel.add(button);
	    mainPanel.add(contentPanel, BorderLayout.CENTER);
	    add(mainPanel);
	}
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(() -> {
	    	RetraitInterface app = new RetraitInterface();
	        app.setVisible(true);
	    });
	}
}

