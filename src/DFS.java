import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class DFS {
    int liczba_wierzcholkow;
    ArrayList<Integer> dostepne_krawedzie;
    Wczytanie wczytanie;
    int[] krawedz;
    int wierzcholek;
    ArrayList<int[]> lista_polaczen;

    ArrayList<Integer> stos;
    HashMap<Integer, ArrayList<Integer>> mapa_polaczen;
    HashMap<Integer, String> kolory;

    public static void main(String[] args) throws IOException{
        DFS dfs = new DFS("C:\\Users\\user\\IdeaProjects\\grafy\\src\\sample.txt");
        dfs.przejscie();
    }

    public DFS(String zrodlo) throws IOException {
        Wczytanie wczytanie = new Wczytanie(zrodlo);
        this.liczba_wierzcholkow = wczytanie.liczba_wierz;
        this.wczytanie = wczytanie;
        this.mapa_polaczen = wczytanie.klucze_polaczen;
        this.kolory = new HashMap<Integer, String>();

    }


    public void przejscie(){
        lista_polaczen = new ArrayList<int[]>();
        stos = new ArrayList<Integer>();
        wierzcholek = 1;


        int i =0;
        while(liczba_wierzcholkow != lista_polaczen.size() - 1 ) {
            dostepne_krawedzie = mapa_polaczen.get(wierzcholek);

            krawedz = new int[2];

            krawedz = pokoloruj_stworz_krawedz(wierzcholek, dostepne_krawedzie, true, "czerwony");
            wierzcholek = krawedz[1];
            if(wierzcholek==0){
                stos.remove(i);
                wierzcholek = stos.get(i-1);
                i--;
            }else{
                i++;
                this.stos.add(wierzcholek);
            }





        }
    }

    private int[] pokoloruj_stworz_krawedz(int wierzcholek, ArrayList<Integer> dostepne_krawedzie, boolean start, String kolor ){
        int[] krawedz = new int[2];
        int cel=0;
        if(dostepne_krawedzie.size()!=0){
            if(start==true) {
                kolor = "czerwony";
                kolory.put(wierzcholek, kolor);
                cel = Collections.min(dostepne_krawedzie);

            }else
                cel = Collections.min(dostepne_krawedzie);
            {
                if (!kolory.containsKey(cel)) {
                    krawedz = new int[2];
                    krawedz[0] = wierzcholek;
                    krawedz[1] = cel;

                    if (kolor.equals("czerwony")) {
                        kolor = "zielony";


                    } else {
                        kolor = "czerwony";
                    }
                    kolory.put(cel, kolor);
                    krawedz[0] = wierzcholek;
                    krawedz[1] = cel;


                }else{
                    int finalCel = cel;
                    dostepne_krawedzie.removeIf(value -> value == finalCel);
                    return pokoloruj_stworz_krawedz(wierzcholek, dostepne_krawedzie, false, kolor);

                }

        }
        }else{
            krawedz[0] = 0;
            krawedz[1] = 0;
        }
        return krawedz;

    }

}
