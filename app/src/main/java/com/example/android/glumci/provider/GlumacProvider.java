package com.example.android.glumci.provider;

import com.example.android.glumci.model.Film;
import com.example.android.glumci.model.Glumac;

import java.util.ArrayList;
import java.util.List;

public class GlumacProvider {

    public static List<Glumac> getGlumac() {

        ArrayList<Film> filmHarrisonFord = new ArrayList<>();
        filmHarrisonFord.add(new Film(0, "Indiana Jones and the Temple of Doom"));
        filmHarrisonFord.add(new Film(1, "Star Wars: Episode VI - Return of the Jedi"));
        filmHarrisonFord.add(new Film(2, "The Fugitive"));

        ArrayList<Film> filmJuliaRoberts = new ArrayList<>();
        filmJuliaRoberts.add(new Film(3, "Pretty Woman "));
        filmJuliaRoberts.add(new Film(4, "Confessions of a Dangerous Mind  "));
        filmJuliaRoberts.add(new Film(5, "Ocean's Eleven "));

        ArrayList<Film> filmBradPitt = new ArrayList<>();
        filmBradPitt.add(new Film(6, "The Curious Case of Benjamin Button  "));
        filmBradPitt.add(new Film(7, "Fight Club "));
        filmBradPitt.add(new Film(8, "Seven Years in Tibet  "));




        ArrayList<Glumac> glumci = new ArrayList<>();
        glumci.add(new Glumac(0, "Harrison Ford", "His father was of Irish and German ancestry, while his maternal grandparents were Jewish immigrants from Minsk, Belarus. Harrison was a lackluster student at ...", "harrison_ford.png", 9.32, "13.07.1942.", "", filmHarrisonFord ));
        glumci.add(new Glumac(1, "Julia Roberts", "She was born in Smyrna, Georgia, to Betty Lou (Bredemus) and Walter Grady Roberts, one-time actors and playwrights, and is of English, Irish, Scottish, Welsh, German, and Swedish descent. As a child...", "julia_roberts.png", 9.22, "28.10.1967.", " ", filmJuliaRoberts ));
        glumci.add(new Glumac(2, "Brad Pitt", "An actor and producer known as much for his versatility as he is for his handsome face, Golden Globe-winner Brad Pitt's most widely recognized role may be Tyler Durden in...", "brad_pitt.png", 9.12, "18.12.1963.", " ", filmBradPitt ));

        return glumci;
    }

    public static List<String> getGlumacIme() {

        List<String> imena = new ArrayList<>();
        imena.add("Harrison Ford");
        imena.add("Julia Roberts");
        imena.add("Brad Pitt");

        return imena;
    }


    public static Glumac getGlumacById(int id) {

        ArrayList<Film> filmHarrisonFord = new ArrayList<>();
        filmHarrisonFord.add(new Film(0, "Indiana Jones and the Temple of Doom"));
        filmHarrisonFord.add(new Film(1, "Star Wars: Episode VI - Return of the Jedi"));
        filmHarrisonFord.add(new Film(2, "The Fugitive"));

        ArrayList<Film> filmJuliaRoberts = new ArrayList<>();
        filmJuliaRoberts.add(new Film(3, "Pretty Woman "));
        filmJuliaRoberts.add(new Film(4, "Confessions of a Dangerous Mind  "));
        filmJuliaRoberts.add(new Film(5, "Ocean's Eleven "));

        ArrayList<Film> filmBradPitt = new ArrayList<>();
        filmBradPitt.add(new Film(6, "The Curious Case of Benjamin Button  "));
        filmBradPitt.add(new Film(7, "Fight Club "));
        filmBradPitt.add(new Film(8, "Seven Years in Tibet  "));



        switch (id) {
            case 0:
                return new Glumac(0, "Harrison Ford", "His father was of Irish and German ancestry, while his maternal grandparents were Jewish immigrants from Minsk, Belarus. Harrison was a lackluster student at ...", "harrison_ford.png", 9.32, "13.07.1942.", "", filmHarrisonFord );
            case 1:
                return new Glumac(1, "Julia Roberts", "She was born in Smyrna, Georgia, to Betty Lou (Bredemus) and Walter Grady Roberts, one-time actors and playwrights, and is of English, Irish, Scottish, Welsh, German, and Swedish descent. As a child...", "julia_roberts.png", 9.22, "28.10.1967.", " ", filmJuliaRoberts );
            case 2:
                return new Glumac(2, "Brad Pitt", "An actor and producer known as much for his versatility as he is for his handsome face, Golden Globe-winner Brad Pitt's most widely recognized role may be Tyler Durden in...", "brad_pitt.png", 9.12, "18.12.1963.", " ", filmBradPitt);
            default:
                return null;
        }
    }

}
