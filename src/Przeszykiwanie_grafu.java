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

    String bool;
    public Przeszykiwanie_grafu(String zrodlo) throws IOException {
        Wczytanie wczytanie = new Wczytanie(zrodlo);
        this.liczba_wierzcholkow = wczytanie.liczba_wierz;
        this.wczytanie = wczytanie;
        this.mapa_polaczen = wczytanie.klucze_polaczen;

        this.temp_mapa_polaczen = wczytanie.temp_klucze_polaczen;
        this.kolory = new HashMap<Integer, String>();

    }
    public void przejscie() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Czy chcesz prześledzić działanie programu? t/n");
        this.bool =  sc.nextLine();
        while (!bool.equals("t") && !bool.equals("n")){
            System.out.println("Podaj prawidłową wartość");
            this.bool = sc.nextLine();
        }
    }

    protected void czy_dwdzielny(){
        Dwudzielnosc_grafu dwudzielnosc_grafu = new Dwudzielnosc_grafu();
        if(dwudzielnosc_grafu.czy_dwudielny(this.kolory, this.temp_mapa_polaczen) == true){
            System.out.println("Graf jest dwudzielny");
        }else{
            System.out.println("Graf nie jest dwudzielny");
        }
    }

    private int[] pokoloruj_stworz_krawedz(){
        int[] kraw = new int[2];

        return kraw;
    }


}
