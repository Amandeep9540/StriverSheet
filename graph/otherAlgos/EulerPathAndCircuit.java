package graph.otherAlgos;

import java.util.ArrayList;
import java.util.List;

public class EulerPathAndCircuit {
    public static void main(String[] args) {
        int V = 3;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        adj.add(new ArrayList<>(List.of(1))); // 0 -> 1
        adj.add(new ArrayList<>(List.of(2))); // 1 -> 2
        adj.add(new ArrayList<>(List.of(0))); // 2 -> 0

        int eulerCon = isEulerCircuit(V,adj);
        if(eulerCon == 0)
            System.out.println("Not Euler Circuit nor the euler path");
        else if(eulerCon == 1)
            System.out.println("Euler Path");
        else
            System.out.println("Euler Circuit");
    }

    public static int isEulerCircuit(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] degree = getDegree(V,adj);
        boolean[] isVisited = new boolean[V];
        dfs(0,adj,isVisited);

        int oddCount = 0;
        for(int i=0;i<degree.length;i++){
            if(degree[i] > 0 && !isVisited[i]) // graph is not connected
                return 0;
            if(degree[i] %2 != 0)
                oddCount++;
        }

        if(oddCount == 2)
            return 1;
        else if(oddCount == 0)
            return 2;

        return 0;
    }


    private static void dfs(int u, ArrayList<ArrayList<Integer>> adj, boolean[] isVisited){
        isVisited[u] = true;
        for(int v : adj.get(u)){
            if(isVisited[v]) continue;
            dfs(v,adj,isVisited);
        }
    }

    private static int[] getDegree(int V, ArrayList<ArrayList<Integer>> adj){
        int[] degree = new int[V];

        for(int i=0;i<V;i++){
            degree[i] = adj.get(i).size();
        }

        return degree;
    }
}
