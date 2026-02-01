package graph.learning;
import java.util.*;

public class PrintAdjacencyList_GFG {
    public static void main(String[] args) {
        int v = 5;
        int e = 7;

        int[][] edges = {
                {0, 1},
                {0, 4},
                {4, 1},
                {4, 3},
                {1, 3},
                {1, 2},
                {3, 2}
        };

        List<List<Integer>> list = printGraph(v,edges);
        for(int i=0;i<list.size();i++){
            System.out.println("Node "+i+" goes to vertex " +list.get(i));
        }
    }

    public static List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        return adjList;
    }
}
