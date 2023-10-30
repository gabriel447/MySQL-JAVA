package org.fullstackgabe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectAllUsers {
    public static void main(String[] args) {
        try (Connection connection = MySqlConnection.getConnection()) {
            String query = "SELECT * FROM Users";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("UserID");
                String firstname = resultSet.getString("FirstName");
                String lastname = resultSet.getString("LastName");
                String city = resultSet.getString("City");


                System.out.println("UserID: " + id);
                System.out.println("FirstName: " + firstname);
                System.out.println("LastName: " + lastname);
                System.out.println("City: " + city);
                System.out.println();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao recuperar os dados dos usuários: " + e.getMessage());
        }
    }
}