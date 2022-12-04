import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Dwudzielnosc_grafuTest {

    @org.junit.jupiter.api.Test
    void czy_dwudielny_dfs() throws IOException {
        DFS dfs = new DFS("C:\\Users\\user\\IdeaProjects\\grafy\\src\\sample.txt");
        Dwudzielnosc_grafu dwudzielnosc_grafu = new Dwudzielnosc_grafu();

        dfs.przejscie();
        assertEquals(true, dwudzielnosc_grafu.czy_dwudielny(dfs.kolory, dfs.temp_mapa_polaczen) );

        DFS dfs_1 = new DFS("C:\\Users\\user\\IdeaProjects\\grafy\\src\\sample_2.txt");
        dfs_1.przejscie();
        assertEquals(true, dwudzielnosc_grafu.czy_dwudielny(dfs_1.kolory, dfs_1.temp_mapa_polaczen) );


        DFS dfs_2 = new DFS("C:\\Users\\user\\IdeaProjects\\grafy\\src\\sample_3.txt");
        dfs_2.przejscie();
        assertEquals(false, dwudzielnosc_grafu.czy_dwudielny(dfs_2.kolory, dfs_2.temp_mapa_polaczen) );

    }

    @org.junit.jupiter.api.Test
    void czy_dwudielny_bfs() throws IOException {
        Dwudzielnosc_grafu dwudzielnosc_grafu = new Dwudzielnosc_grafu();

        BFS bfs = new BFS("C:\\Users\\user\\IdeaProjects\\grafy\\src\\sample.txt");
        bfs.przejscie();
        assertEquals(true, dwudzielnosc_grafu.czy_dwudielny(bfs.kolory, bfs.temp_mapa_polaczen) );

        BFS bfs1 = new BFS("C:\\Users\\user\\IdeaProjects\\grafy\\src\\sample_2.txt");
        bfs1.przejscie();
        assertEquals(true, dwudzielnosc_grafu.czy_dwudielny(bfs1.kolory, bfs1.temp_mapa_polaczen) );

        BFS bfs_2 = new BFS("C:\\Users\\user\\IdeaProjects\\grafy\\src\\sample_3.txt");
        bfs_2.przejscie();

        assertEquals(false, dwudzielnosc_grafu.czy_dwudielny(bfs_2.kolory, bfs_2.temp_mapa_polaczen) );





}}