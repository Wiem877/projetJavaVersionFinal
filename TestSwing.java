import javax.swing.*;

public class TestSwing 
{
    public static void main(String[] args) {
        // Crée une fenêtre (JFrame)
        JFrame frame = new JFrame("Test Swing");
        
        // Configure la fenêtre
        frame.setSize(300, 200); // Largeur x Hauteur
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ferme le programme à la fermeture de la fenêtre

        // Affiche la fenêtre
        frame.setVisible(true);
    }
}