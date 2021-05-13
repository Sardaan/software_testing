package lab1.graph;

public class Dijkstra {
    public static int[] dijkstra(int[][] adjacencyMatrix){
        if (adjacencyMatrix == null){
            throw new IllegalArgumentException();
        }
        int v = adjacencyMatrix.length;
        boolean visited[] = new boolean[v];
        int distance[] = new int[v];

        distance[0] = 0;
        for(int i = 1; i < v; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < v-1; i++){
            int minVertex = findMinVertex(distance, visited);
            visited[minVertex] = true;
            for(int j = 0; j < v; j++){
                if (adjacencyMatrix[minVertex][j] != 0 && !visited[j] && distance[minVertex] != Integer.MAX_VALUE){
                    int newDistance = distance[minVertex] + adjacencyMatrix[minVertex][j];
                    if (newDistance < distance[j]){
                        distance[j] = newDistance;
                    }

                }
            }
        }
        for(int i = 0; i < v; i++){
            if(distance[i] == Integer.MAX_VALUE){
                distance[i] = -1;
            }
        }
        return distance;
    }


    private static int findMinVertex(int[] distance, boolean visited[]){
        int minVertex = -1;
        for(int i = 0; i < distance.length; i++){
            if(!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])){
                minVertex = i;
            }
        }
        return minVertex;
    }



}
