package graph.shortestPath;
import java.util.*;

public class BellmanFordAlgo {
    static int x = 1_0000_0000;   // 10^8

    public static void main(String[] args) {
        int[][] edges =  {{1, 3, 2}, {4, 3, -1}, {2, 4, 1}, {1, 2, 1}, {0, 1, 5}};
        int[] shortestPath = bellmanFord(5,edges,0);
        for(int x : shortestPath){
            System.out.print(x + " ");
        }
    }

    public static int[] bellmanFord(int V, int[][] edges, int src) {
        //STEP 1 :: creating the distance array and initilize that
        int[] dis = new int[V];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src] = 0;

        //STEP 2 :: creating the list of adjaceny list
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++)
            adjList.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];int v = edges[i][1];int wt = edges[i][2];
            adjList.get(u).add(new Pair(v,wt));
        }

        //STEP 3 :: relax the edges V-1 times
        for(int i =0;i<V-1;i++){
            // relaxing the edges
            int currentEdge = 0;
            for(List<Pair> vertextEdges : adjList){
                if(dis[currentEdge] != Integer.MAX_VALUE){  // we can relax the eges related to this vertex
                    for(Pair vertexEdge : vertextEdges){
                        if(dis[currentEdge] + vertexEdge.dist() < dis[vertexEdge.node()]){
                            dis[vertexEdge.node()] = dis[currentEdge] + vertexEdge.dist();
                        }
                    }
                }
                currentEdge++;
            }
        }

        //STEP 4 :: if the edge relax one more time if any dis change that means there is a negative cycle
        int currentEdge = 0;
        int count = 0;
        for(List<Pair> vertextEdges : adjList){
            if(dis[currentEdge] != Integer.MAX_VALUE){ // we can relax the eges related to this vertex
                for(Pair vertexEdge : vertextEdges){
                    if(dis[currentEdge] + vertexEdge.dist() < dis[vertexEdge.node()]){
                        return new int[]{-1};
                    }
                }
            }
            currentEdge++;
        }

        for(int i=0;i<dis.length;i++){
            if(dis[i] == Integer.MAX_VALUE)
                dis[i] = x;
        }
        return dis;
    }
}

record Pair(int node, int dist) {}