package graph.shortestPath;

import java.util.Arrays;

public class FloydWarshall_GFG {
    static int INF = 100_000_000; // 10^8
    public static void main(String[] args) {
        int[][] dist = {
                {0,   4,   INF, 5,   INF},
                {INF, 0,   1,   INF, 6},
                {2,   INF, 0,   3,   INF},
                {INF, INF, 1,   0,   2},
                {1,   INF, INF, 4,   0}
        };
        floydWarshall(dist);
        for(int i=0;i<dist.length;i++){
            for(int j=0;j<dist.length;j++){
                System.out.println("shortest path from "+i+ " to "+j+" -- "+dist[i][j]);
            }
        }
    }

    public static void floydWarshall(int[][] dist) {
        for(int viz = 0;viz<dist.length;viz++){
            // edge -> viz -> edge
            for(int i=0;i<dist.length;i++){ // source
                for(int j=0;j<dist.length;j++){ //destination
                    if(i == j) continue;
                    if(dist[i][viz] == INF || dist[viz][j] == INF ) continue;
                    dist[i][j] = Math.min(dist[i][j] , dist[i][viz] + dist[viz][j]);
                }
            }
        }
    }
}
