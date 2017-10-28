package com.example.android.glumci.model;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

public class Glumac {

    private int id;
    private String ime;
    private String biografija;
    private String fotografija;
    private double ocena;
    private String datumRodjenja;
    private String datumSmrti;
    private ArrayList<Film> filmovi;


    public Glumac() {
        this.filmovi = new ArrayList<Film>();
    }

    public Glumac(int id, String ime, String biografija, String fotografija, double ocena, String datumRodjenja, String datumSmrti, ArrayList<Film> filmovi) {
        this.id = id;
        this.ime = ime;
        this.biografija = biografija;
        this.fotografija = fotografija;
        this.ocena = ocena;
        this.datumRodjenja = datumRodjenja;
        this.datumSmrti = datumSmrti;
        this.filmovi = filmovi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getBiografija() {
        return biografija;
    }

    public void setBiografija(String biografija) {
        this.biografija = biografija;
    }

    public String getFotografija() {
        return fotografija;
    }

    public void setFotografija(String fotografija) {
        this.fotografija = fotografija;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }

    public String getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(String datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getDatumSmrti() {
        return datumSmrti;
    }

    public void setDatumSmrti(String datumSmrti) {
        this.datumSmrti = datumSmrti;
    }

    public ArrayList<Film> getFilmovi() {
        return filmovi;
    }

    public void setFilmovi(ArrayList<Film> filmovi) {
        this.filmovi = filmovi;
    }

    // dodatne metode

    public void addFilm(Film film) {

        filmovi.add(film);
    }

    public void removeFilm(Film film) {

        filmovi.remove(film);
    }

    public Film getFilm(int position) {

        return filmovi.get(position);
    }


    @Override
    public String toString() {;
        return ime;
    }
}


