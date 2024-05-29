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
            System.out.println("1. Afegir autor");
            System.out.println("2. Afegir llibre");
            System.out.println("3. Mostrar llibres del autor");
            System.out.println("4. Mostrar autors");
            System.out.println("5. Sortir");
            System.out.print("Selecciona una opcio: ");
            int opcio = scanner.nextInt();

            switch (opcio) {
                case 1:
                    System.out.print("Introdueix el nom de l'autor: ");
                    String nom = scanner.next();
                    System.out.print("Introdueix el cognom de l'autor: ");
                    String cognom = scanner.next();
                    dbManager.afegirAutor(nom, cognom);
                    break;
                case 2:
                    System.out.print("Introdueix el titol del llibre: ");
                    String titol = scanner.next();
                    System.out.print("Introdueix l'any de publicacio del llibre: ");
                    String anyPublicacio = scanner.next();
                    System.out.print("Introdueix l'ID de l'autor: ");
                    int autorId = scanner.nextInt();
                    dbManager.afegirLlibre(titol, anyPublicacio, autorId);
                    break;
                case 3:
                    System.out.print("Introdueix l'ID de l'autor: ");
                    int autorIdLlibre = scanner.nextInt();
                    dbManager.llibresDelAutor(autorIdLlibre);
                    break;
                case 4:
                    dbManager.mostrarAutor();
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
