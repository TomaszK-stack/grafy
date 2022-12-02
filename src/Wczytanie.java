import java.io.*;
import java.util.Arrays;

public class Wczytanie {
    String zrodlo;
    int liczba_wierz;
    int liczba_pol;

    private String[] wartosci;
    private  String join;
    private String[] polaczenie;

    private int[] docelowe_wartosci = new int[2];
    int[][] tablica_wartosci;

    public Wczytanie(String zrodlo) throws IOException {
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
                this.tablica_wartosci = new int[this.wartosci.length][2];
                for(String s: this.wartosci){
                    s = s.strip();
                    polaczenie = s.split(" ");
                    this.docelowe_wartosci[0] = Integer.parseInt(this.polaczenie[0]);
                    this.docelowe_wartosci[1] = Integer.parseInt(this.polaczenie[1]);
                    this.tablica_wartosci[i] = this.docelowe_wartosci;
                    i++;
                }

            }
            licznik++;
        }
        for (int x[]: this.tablica_wartosci){
            System.out.println(x[0]);
        }





    }
}
