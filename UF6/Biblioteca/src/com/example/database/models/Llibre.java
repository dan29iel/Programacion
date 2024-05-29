/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.database.models;

public class Llibre {
    private int id;
    private String titol;
    private String anyPublicacio;
    private int autorId;

    public Llibre(int id, String titol, String anyPublicacio, int autorId) {
        this.id = id;
        this.titol = titol;
        this.anyPublicacio = anyPublicacio;
        this.autorId = autorId;
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

    public String getAnyPublicacio() {
        return anyPublicacio;
    }

    public void setAnyPublicacio(String anyPublicacio) {
        this.anyPublicacio = anyPublicacio;
    }

    public int getAutorId() {
        return autorId;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }

    @Override
    public String toString() {
        return "Llibre {id=" + id + ", titol=" + titol + ", anyPublicacio=" + anyPublicacio + ", autorId=" + autorId + "}";
    }
}

