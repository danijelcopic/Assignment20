package com.example.android.glumci.model;

import java.util.ArrayList;

public class Film {

    private int id;
    private String film;
    private ArrayList<Glumac> glumci;

    public Film() {
        this.glumci = new ArrayList<Glumac>();
    }

    public Film(int id, String film) {
        this.id = id;
        this.film = film;
    }

    public Film(int id, String film, ArrayList<Glumac> glumci) {
        this.id = id;
        this.film = film;
        this.glumci = glumci;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public ArrayList<Glumac> getGlumci() {
        return glumci;
    }

    public void setGlumci(ArrayList<Glumac> glumci) {
        this.glumci = glumci;
    }

    @Override
    public String toString() {
        return film;
    }
}
