/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.database;

import java.sql.*;

public class DatabaseManager {
    private Connection connexio;

    public void connect() {
        try {
            connexio = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/Llibreria", "postgres", "students1234");
            System.out.println("Connexio establerta");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void afegirLlibre(String titol, String autor, int anyPublicacio) {
        String consulta = "INSERT INTO Llibre (titol, autor, anyPublicacio) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connexio.prepareStatement(consulta);
            stmt.setString(1, titol);
            stmt.setString(2, autor);
            stmt.setInt(3, anyPublicacio);
            stmt.executeUpdate();
            System.out.println("Llibre afegit");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrarLlibres() {
        String consulta = "SELECT * FROM Llibre";
        try {
            PreparedStatement stmt = connexio.prepareStatement(consulta);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Titol: " + rs.getString("titol") + ", Autor: " + rs.getString("autor") + ", Any de Publicacio: " + rs.getInt("anyPublicacio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualitzarLlibre(int id, String titol, String autor, int anyPublicacio) {
        String consulta = "UPDATE Llibre SET titol = ?, autor = ?, anyPublicacio = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connexio.prepareStatement(consulta);
            stmt.setString(1, titol);
            stmt.setString(2, autor);
            stmt.setInt(3, anyPublicacio);
            stmt.setInt(4, id);
            stmt.executeUpdate();
            System.out.println("Llibre actualitzat");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarLlibre(int id) {
        String consulta = "DELETE FROM Llibre WHERE id = ?";
        try {
            PreparedStatement stmt = connexio.prepareStatement(consulta);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Llibre eliminat");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void desconnectar() {
        try {
            if (connexio != null && !connexio.isClosed()) {
                connexio.close();
                System.out.println("Connexio tancada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
