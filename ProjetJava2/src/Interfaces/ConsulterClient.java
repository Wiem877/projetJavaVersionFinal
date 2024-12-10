package Interfaces;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import ClassesPrincipaux.Connecter;

import java.sql.Connection;
public class ConsulterClient 
{
	public static Vector recupererLigne(String query) throws SQLException {
        Vector info = new Vector();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try 
        {
        	connection = Connecter.obtenirConnection();
            statement = connection.createStatement(); // creer la requete
            resultSet = statement.executeQuery(query); // executer la requette
            int columnCount = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                Vector row = new Vector();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(resultSet.getObject(i));
                }
                info.add(row);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return info;
    }

    public static Vector getTableColumns(String query) throws SQLException {
        Vector columns = new Vector();
        try (Connection connection = Connecter.obtenirConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) 
        {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                columns.add(metaData.getColumnName(i));
            }
        }
        return columns;
    }
}

