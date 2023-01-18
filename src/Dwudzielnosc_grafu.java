import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dwudzielnosc_grafu {

    public boolean czy_dwudielny(HashMap<Integer, String> kolory, HashMap<Integer, ArrayList<Integer>> mapa_polaczen){
        int key;
        String kolor;
        ArrayList<Integer> temp_table;
        for(Map.Entry<Integer, String> entry: kolory.entrySet()){
            key = entry.getKey();
            kolor = entry.getValue();
            temp_table = mapa_polaczen.get(key);
            for(Integer x: temp_table){
                if(kolor.equals(kolory.get(x))){
                    System.out.println("Wierzchołek " + key + " i wierzchołek " + x + " mają takie same kolory a sąsiadują ze sobą");
                    return false;
                }
            }

        }
        return true;
    }

}
