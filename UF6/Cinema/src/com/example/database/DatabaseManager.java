/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManager {
    private Connection connection;

    public void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/cinema", "postgres", "students1234");
            System.out.println("Connexió establerta");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void afegirDirector(String nom, String cognom) {
        String query = "INSERT INTO Director (nom, cognom) VALUES (?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, nom);
            stmt.setString(2, cognom);
            stmt.executeUpdate();
            System.out.println("Director afegit");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void afegirPelicula(String titol, int anyEstrena, int idDirector) {
        String query = "INSERT INTO Pelicula (titol, anyEstrena, idDirector) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, titol);
            stmt.setInt(2, anyEstrena);
            stmt.setInt(3, idDirector);
            stmt.executeUpdate();
            System.out.println("Pelicula afegida");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void peliculesDelDirector(int idDirector) {
        String query = "SELECT Pelicula.titol, Pelicula.anyEstrena FROM Pelicula WHERE idDirector = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, idDirector);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Titol: " + rs.getString("titol") + ", Any d'Estrena: " + rs.getInt("anyEstrena"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrarDirector() {
        String query = "SELECT * FROM Director";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Nom: " + rs.getString("nom") + ", Cognom: " + rs.getString("cognom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connexió tancada");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}