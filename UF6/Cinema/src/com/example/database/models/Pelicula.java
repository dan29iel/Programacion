/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.database.models;

public class Pelicula {
    private int id;
    private String titol;
    private int anyEstrena;
    private int idDirector;

    public Pelicula(int id, String titol, int anyEstrena, int idDirector) {
        this.id = id;
        this.titol = titol;
        this.anyEstrena = anyEstrena;
        this.idDirector = idDirector;
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

    public int getAnyEstrena() {
        return anyEstrena;
    }

    public void setAnyEstrena(int anyEstrena) {
        this.anyEstrena = anyEstrena;
    }

    public int getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(int idDirector) {
        this.idDirector = idDirector;
    }

    @Override
    public String toString() {
        return "Pelicula (id=" + id + ", titol=" + titol + ", anyEstrena=" + anyEstrena + ", directorId=" + idDirector + ")";
    }
}
