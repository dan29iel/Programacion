/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.database;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseManager gestorBD = new DatabaseManager();

        gestorBD.connect();

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n********Menu********");
            System.out.println("1. Afegir llibre");
            System.out.println("2. Mostrar llibres");
            System.out.println("3. Actualitzar llibre");
            System.out.println("4. Eliminar llibre");
            System.out.println("5. Sortir");
            System.out.print("Selecciona una opcio: ");
            int opcio = scanner.nextInt();

            switch (opcio) {
                case 1:
                    System.out.print("Introdueix el titol del llibre: ");
                    String titol = scanner.next();
                    System.out.print("Introdueix l'autor del llibre: ");
                    String autor = scanner.next();
                    System.out.print("Introdueix l'any de publicacio del llibre: ");
                    int anyPublicacio = scanner.nextInt();
                    gestorBD.afegirLlibre(titol, autor, anyPublicacio);
                    break;
                case 2:
                    gestorBD.mostrarLlibres();
                    break;
                case 3:
                    System.out.print("Introdueix l'ID del llibre per actualitzar-lo: ");
                    int idLlibre = scanner.nextInt();
                    System.out.print("Introdueix el nou titol: ");
                    String nouTitol = scanner.next();
                    System.out.print("Introdueix el nou autor: ");
                    String nouAutor = scanner.next();
                    System.out.print("Introdueix el nou any de publicació: ");
                    int nouAnyPublicacio = scanner.nextInt();
                    gestorBD.actualitzarLlibre(idLlibre, nouTitol, nouAutor, nouAnyPublicacio);
                    break;
                case 4:
                    System.out.print("Introdueix l'ID del llibre per eliminar: ");
                    int idEliminar = scanner.nextInt();
                    gestorBD.eliminarLlibre(idEliminar);
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcio no valida");
                    break;
            }
        }

        gestorBD.desconnectar();
        scanner.close();
    }
}
