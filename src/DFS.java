import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.Scanner;

public class DFS extends Przeszykiwanie_grafu{


    public DFS(String zrodlo) throws IOException {

        super(zrodlo);

    }

    public static void main(String[] args) throws IOException{

        DFS dfs = new DFS("C:\\Users\\user\\IdeaProjects\\grafy\\src\\sample_3.txt");
        dfs.przejscie();
    }



    public void przejscie() throws IOException{


        lista_polaczen = new ArrayList<int[]>();
        stos = new ArrayList<Integer>();
        wierzcholek = 1;


        int i =0;
        kolory.put(wierzcholek, "czerwony");
        Scanner sc = new Scanner(System.in);
        System.out.println("Czy chcesz prześledzić działanie programu? true/false");
        boolean bool =  true   ;


        while(liczba_wierzcholkow-1 != lista_polaczen.size()  ) {
            dostepne_krawedzie = mapa_polaczen.get(wierzcholek);

            krawedz = new int[2];

            krawedz = pokoloruj_stworz_krawedz(wierzcholek, dostepne_krawedzie, bool);
            wierzcholek = krawedz[1];
            if(wierzcholek==0){
                stos.remove(i-1);
                wierzcholek = stos.get(i-2);
                i--;
            }else{

                this.stos.add(wierzcholek);
                lista_polaczen.add(krawedz);
                i++;
            }





        }
        BFS.zapisz_do_pliku(kolory, "C:\\Users\\user\\IdeaProjects\\grafy\\src\\output_2.txt");

    }

    private int[] pokoloruj_stworz_krawedz(int wierzcholek, ArrayList<Integer> dostepne_krawedzie, boolean bool ){
        int[] krawedz = new int[2];
        int cel=0;
        String kolor="";
        Scanner sc = new Scanner(System.in);



        if(dostepne_krawedzie.size()!=0){

            cel = Collections.min(dostepne_krawedzie);

                if (!kolory.containsKey(cel)) {
                    krawedz = new int[2];
                    krawedz[0] = wierzcholek;
                    krawedz[1] = cel;
                    kolor = kolory.get(wierzcholek);

                    if (kolor.equals("czerwony")) {
                        kolor = "zielony";


                    } else {
                        kolor = "czerwony";
                    }
                    kolory.put(cel, kolor);
                    if(bool==true){
                        System.out.println("Pokolorowano wierzchołek " + cel + " na kolor "+ kolor);

                    }
                    krawedz[0] = wierzcholek;

                    krawedz[1] = cel;
                    System.out.println("Przechodzimy z wierzchołka " + wierzcholek + " na " + cel);
//                    String st = sc.nextLine();

                }else{

                    int finalCel = cel;
                    dostepne_krawedzie.removeIf(value -> value == finalCel);
                    return pokoloruj_stworz_krawedz(wierzcholek, dostepne_krawedzie, bool);



        }
        }else{
            krawedz[0] = 0;
            krawedz[1] = 0;
        }
        return krawedz;

    }

}
