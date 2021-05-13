package lab1.graph;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;


public class DijkstraTest {

    int[][] matrixTest;
    int [] expected;
    int[][] oneMatrix;
    int[][] nullMatrix;
    int[][] zeroMatrix;
    int[][] matrixNotConnected;

    @BeforeEach
    private void init(){
        matrixTest = new int[][] {{0, 0, 6, 3, 2, 0, 0, 0},
                {0, 0, 4, 8, 0, 0, 0, 0},
                {6, 4, 0, 0, 8, 0, 9, 0},
                {3, 8, 0, 0, 0, 1, 0, 0},
                {2, 0, 8, 0, 0, 0, 0, 3},
                {0, 0, 0, 1, 0, 0, 7, 0},
                {0, 0, 9, 0, 0, 7, 0, 2},
                {0, 0, 0, 0, 3, 0, 2, 0}};
        expected = new int[]{0, 10, 6, 3, 2, 4, 7, 5};
        oneMatrix = new int [][] {{0}};
        nullMatrix = null;
        zeroMatrix = new int [][] {{0,0,0},{0,0,0},{0,0,0}};
        matrixNotConnected = new int [][] {{0,1,0},{1,0,0},{0,0,0}};
    }
    @Test
    public void dijkstra_sampleCheckTest() {

        assertAll(
                () -> assertEquals(expected[0], Dijkstra.dijkstra(matrixTest)[0]),
                () -> assertEquals(expected[1], Dijkstra.dijkstra(matrixTest)[1]),
                () -> assertEquals(expected[2], Dijkstra.dijkstra(matrixTest)[2]),
                () -> assertEquals(expected[3], Dijkstra.dijkstra(matrixTest)[3]),
                () -> assertEquals(expected[4], Dijkstra.dijkstra(matrixTest)[4]),
                () -> assertEquals(expected[5], Dijkstra.dijkstra(matrixTest)[5]),
                () -> assertEquals(expected[6], Dijkstra.dijkstra(matrixTest)[6])
        );
    }

    @Test
    public void dijkstra_oneMatrixTest(){
        assertEquals(0, Dijkstra.dijkstra(oneMatrix)[0]);
    }

    @Test
    public void dijkstra_nullMatrixTest(){
        assertThrows(IllegalArgumentException.class, () -> Dijkstra.dijkstra(nullMatrix));
    }

    @Test
    public void dijkstra_zeroMatrixTest(){
        assertAll(
                () -> assertEquals(0, Dijkstra.dijkstra(zeroMatrix)[0]),
                () -> assertEquals(-1, Dijkstra.dijkstra(zeroMatrix)[1]),
                () -> assertEquals(-1, Dijkstra.dijkstra(zeroMatrix)[2]));
    }

    @Test
    public void dijkstra_notConnectedMatrixTest(){

        assertAll(
                () -> assertEquals(0, Dijkstra.dijkstra(matrixNotConnected)[0]),
                () -> assertEquals(1, Dijkstra.dijkstra(matrixNotConnected)[1]),
                () -> assertEquals(-1, Dijkstra.dijkstra(matrixNotConnected)[2]));
    }


}
