package services;

import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Properties;

import javax.swing.JOptionPane;

import ClassesPrincipaux.Client;

public class ClientServiceImpl implements ClientService{
	private static final String URL = "jdbc:mysql://localhost:3306/gestion"; // Remplacez par votre URL
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    @Override
    public void insererClient(Client client) {
        String sql = "INSERT INTO client (numCin, nom, prenom, tel) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, client.getCin());
            statement.setString(2, client.getNom());
            statement.setString(3, client.getPrenom());
            statement.setInt(4, client.getTel());
            statement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("CIN existe déjà dans la base de données.");
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public Client consulterClient(int cin) {
        String sql = "SELECT * FROM clients WHERE numCin = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, cin);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Client(
                        resultSet.getInt("numCin"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getInt("tel")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean modifierClient(Client client) {
        String sql = "UPDATE clients SET nom = ?, prenom = ?, tel = ? WHERE numCin = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, client.getNom());
            statement.setString(2, client.getPrenom());
            statement.setInt(3, client.getTel());
            statement.setInt(4, client.getCin());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
    }

    @Override
    public void supprimerClient(int cin) {
        String sql = "DELETE FROM clients WHERE numCin = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, cin);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
