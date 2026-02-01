package graph.learning;

import java.util.*;

public class GraphBFSTraversal_GFG {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        adj.add(new ArrayList<>(Arrays.asList(2, 3, 1)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(2)));

        List<Integer> bfsTravel = bfs(adj);
        System.out.println(bfsTravel);
    }
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        Deque<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] isVisited = new boolean[adj.size()];
        queue.offer(0);
        while(!queue.isEmpty()){
            int u = queue.poll();
            if(isVisited[u]) continue;
            result.add(u);
            isVisited[u] = true;
            for(int v : adj.get(u)){
                if(isVisited[v] == false){
                    queue.offer(v);
                }
            }
        }
        return result;
    }
}
