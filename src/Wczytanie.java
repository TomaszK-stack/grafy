import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Wczytanie {
    ArrayList<int[]> tablica_wartosci;
    public HashMap<Integer, ArrayList<Integer>> klucze_polaczen;

    String zrodlo;
    int liczba_wierz;
    int liczba_pol;


    ///pomocnicze zmienne:

    private String[] wartosci;
    private  String join;
    private String[] polaczenie;

    private int[] docelowe_wartosci;

    public Wczytanie(String zrodlo) throws IOException {

        tablica_wartosci = new ArrayList<int[]>();
        this.zrodlo = zrodlo;
        String st;
        File file = new File(zrodlo);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String[] tabela;
        String zmienna;




        int licznik =0;
        while(((st=br.readLine()) !=null)){

            if(licznik < 2) {
                tabela = st.split(":");
                zmienna = tabela[1];
                if(licznik==0){
                    liczba_wierz = Integer.parseInt(zmienna.strip());
                }else if(licznik==1){
                    liczba_pol = Integer.parseInt(zmienna.strip());


            }

            }else{
                int i =0 ;
                this.wartosci = st.split(",");
                int[] temp_table;
                for(String s: this.wartosci){
                    s = s.strip();
                    polaczenie = s.split(" ");
                    this.docelowe_wartosci = new int[2];
                    this.docelowe_wartosci[0] = Integer.parseInt(this.polaczenie[0].strip());
                    this.docelowe_wartosci[1] = Integer.parseInt(this.polaczenie[1].strip());

                    tablica_wartosci.add(this.docelowe_wartosci);
                     i++;
                }

            }
            licznik++;
        }

//        for (int[] x: tablica_wartosci){
//            System.out.println(Arrays.deepToString(new int[][]{Arrays.stream(x).toArray()}));
//        }


        this.klucze_polaczen = utworz_klucze_polaczen(this.tablica_wartosci);

    }

    private HashMap<Integer, ArrayList<Integer>> utworz_klucze_polaczen(ArrayList<int[]> lista_polaczen){ ////tworzymy możliwy hashmapę możliwych połaczeń
        HashMap<Integer, ArrayList<Integer>> wynik = new HashMap<Integer, ArrayList<Integer>>();
        ArrayList<Integer> temp_array;
        for(int[] x: lista_polaczen){
            if(wynik.containsKey(x[0])){
                temp_array = wynik.get(x[0]);
                temp_array.add(x[1]);
                wynik.replace(x[0], temp_array);

            }else{
                temp_array = new ArrayList<Integer>();
                temp_array.add(x[1]);
                wynik.put(x[0], temp_array);

            }

        }


        return wynik;

    }

}
