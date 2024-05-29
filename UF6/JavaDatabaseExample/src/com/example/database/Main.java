/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.database;

import com.example.database.models.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseManager dbManager = new DatabaseManager();

        dbManager.connect();

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n********Menu********");
            System.out.println("1. Afegir estudiant");
            System.out.println("2. Mostrar estudiant");
            System.out.println("3. Modificar estudiant");
            System.out.println("4. Eliminar estudiant");
            System.out.println("5. Sortir");
            System.out.print("Selecciona una opcio: ");
            int opcio = scanner.nextInt();

            switch (opcio) {
                case 1:
                    System.out.print("Introdueix el nom de l'estudiant: ");
                    String name = scanner.next();
                    System.out.print("Introdueix el cognom de l'estudiant: ");
                    String lastName = scanner.next();
                    Student newStudent = new Student(0, name, lastName);
                    dbManager.addStudent(newStudent);
                    break;
                case 2:
                    System.out.print("Introdueix l'ID de l'estudiant: ");
                    int idStudent = scanner.nextInt();
                    Student showStudent = dbManager.getStudent(idStudent);
                    System.out.println(showStudent);
                    break;
                case 3:
                    System.out.print("Introdueix l'ID de l'estudiant per modificar: ");
                    int idModify = scanner.nextInt();
                    System.out.print("Introdueix el nom de l'estudiant: ");
                    String newName = scanner.next();
                    System.out.print("Introdueix el cognom de l'estudiant: ");
                    String newLastName = scanner.next();
                    Student studentModify = new Student(idModify, newName, newLastName);
                    dbManager.updateStudent(studentModify);
                    break;
                case 4:
                    System.out.print("Introdueix l'ID de l'estudiant per eliminar: ");
                    int idDelete = scanner.nextInt();
                    dbManager.deleteStudent(idDelete);
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcio no valida.");
                    break;
            }
        }
        dbManager.disconnect();
        scanner.close();
    }
}




