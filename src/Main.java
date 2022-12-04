import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        DFS dfs = new DFS("C:\\Users\\user\\IdeaProjects\\grafy\\src\\sample_3.txt");
        dfs.przejscie();
        Dwudzielnosc_grafu dwudzielnosc_grafu = new Dwudzielnosc_grafu();
        System.out.println(dfs.temp_mapa_polaczen);
        System.out.println("To jest mapa");
        System.out.print(dwudzielnosc_grafu.czy_dwudielny(dfs.kolory, dfs.temp_mapa_polaczen));

    }
}