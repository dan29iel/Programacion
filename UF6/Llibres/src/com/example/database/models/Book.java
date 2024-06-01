/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.database.models;

public class Book {
    private int id;
    private String titol;
    private String autor;
    private int anyPublicacio;

    public Book(int id, String titol, String autor, int anyPublicacio) {
        this.id = id;
        this.titol = titol;
        this.autor = autor;
        this.anyPublicacio = anyPublicacio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnyPublicacio() {
        return anyPublicacio;
    }

    public void setAnyPublicacio(int anyPublicacio) {
        this.anyPublicacio = anyPublicacio;
    }

    @Override
    public String toString() {
        return "Llibre (id=" + id + ", titol=" + titol + ", autor=" + autor + ", anyPublicacio=" + anyPublicacio + ")";
    }
}
