import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BFS extends Przeszykiwanie_grafu{

    public static void main(String[] args) throws  IOException{
        BFS bfs = new BFS("C:\\Users\\user\\IdeaProjects\\grafy\\src\\sample.txt");
        bfs.przejscie();
    }


    public BFS(String zrodlo) throws IOException {
        super(zrodlo);
        this.lista_polaczen = new ArrayList<int[]>();
    }



    @Override
    public void przejscie() throws IOException {
        this.wierzcholek = 1;

        String kolor = "czerwony";
        ArrayList<Integer> kolejka = new ArrayList<Integer>();


        while(liczba_wierzcholkow-1 != lista_polaczen.size()){
            if(!kolory.containsKey(wierzcholek)) {
                kolory.put(wierzcholek, kolor);
            }
                dostepne_krawedzie = mapa_polaczen.get(wierzcholek);
            pokoloruj_stworz_krawedz(wierzcholek, dostepne_krawedzie);
            for(int x: dostepne_krawedzie){
                if(!kolejka.contains(x)){
                    kolejka.add(x);
                }
            }
            if(kolejka.size()!=0){
                wierzcholek = kolejka.get(0);
                kolejka.removeIf(value -> value == wierzcholek);

            }else{
                wierzcholek = dostepne_krawedzie.get(0);
            }






        }

        zapisz_do_pliku(kolory, "C:\\Users\\user\\IdeaProjects\\grafy\\src\\output.txt");
    }
    private void pokoloruj_stworz_krawedz(int wierzcholek, ArrayList<Integer> dostepne_krawedzie ){
        String kolor = "";
        int[] krawadz;
        for(int x: dostepne_krawedzie){

            if(!kolory.containsKey(x)){
                krawadz = new int[2];
                kolor = kolory.get(wierzcholek);
                if(kolor.equals("czerwony")){
                    kolor = "zielony";
                }else{
                    kolor = "czerwony";
                }
                kolory.put(x, kolor);
                krawadz[0] = wierzcholek;
                krawadz[1] = x;
                this.lista_polaczen.add(krawadz);
            }


        }



    }

    public static void zapisz_do_pliku(HashMap<Integer, String> kolory, String zrodlo) throws IOException{
        File file = new File(zrodlo);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bf = new BufferedWriter(fileWriter);

       for(Map.Entry<Integer, String> entry: kolory.entrySet()){
           bf.write(entry.getKey() + ":"
                   + entry.getValue());

           // new line
           bf.newLine();
       }
    bf.close();

    }


}
