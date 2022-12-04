import java.io.IOException;
import java.util.*;

public abstract class  Przeszykiwanie_grafu {
    int liczba_wierzcholkow;
    ArrayList<Integer> dostepne_krawedzie;
    Wczytanie wczytanie;
    int[] krawedz;
    int wierzcholek;
    ArrayList<int[]> lista_polaczen;

    ArrayList<Integer> stos;
    HashMap<Integer, ArrayList<Integer>> mapa_polaczen;
    HashMap<Integer, ArrayList<Integer>> temp_mapa_polaczen;
    HashMap<Integer, String> kolory;

    Dwudzielnosc_grafu dwudzielnosc_grafu;
    public Przeszykiwanie_grafu(String zrodlo) throws IOException {
        Wczytanie wczytanie = new Wczytanie(zrodlo);
        this.liczba_wierzcholkow = wczytanie.liczba_wierz;
        this.wczytanie = wczytanie;
        this.mapa_polaczen = wczytanie.klucze_polaczen;

        this.temp_mapa_polaczen = wczytanie.temp_klucze_polaczen;
        this.kolory = new HashMap<Integer, String>();

    }
    public void przejscie() throws IOException {

    }

    private int[] pokoloruj_stworz_krawedz(){
        int[] kraw = new int[2];

        return kraw;
    }


}
