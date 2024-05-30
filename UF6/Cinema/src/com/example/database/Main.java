/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.database;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseManager dbManager = new DatabaseManager();

        dbManager.connect();

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n********Menu********");
            System.out.println("1. Afegir director");
            System.out.println("2. Afegir pelicula");
            System.out.println("3. Mostrar pelicules del director");
            System.out.println("4. Mostrar directors");
            System.out.println("5. Sortir");
            System.out.print("Selecciona una opcio: ");
            int opcio = scanner.nextInt();

            switch (opcio) {
                case 1:
                    System.out.print("Introdueix el nom del director: ");
                    String nom = scanner.next();
                    System.out.print("Introdueix el cognom del director: ");
                    String cognom = scanner.next();
                    dbManager.afegirDirector(nom, cognom);
                    break;
                case 2:
                    System.out.print("Introdueix el titol de la pelicula: ");
                    String titol = scanner.next();
                    System.out.print("Introdueix l'any d'estrena de la pelicula: ");
                    int anyEstrena = scanner.nextInt();
                    System.out.print("Introdueix l'ID del director: ");
                    int idDirector = scanner.nextInt();
                    dbManager.afegirPelicula(titol, anyEstrena, idDirector);
                    break;
                case 3:
                    System.out.print("Introdueix l'ID del director: ");
                    int directorIdConsulta = scanner.nextInt();
                    dbManager.peliculesDelDirector(directorIdConsulta);
                    break;
                case 4:
                    dbManager.mostrarDirector();
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcio no valida");
                    break;
            }
        }

        dbManager.disconnect();
        scanner.close();
    }
}