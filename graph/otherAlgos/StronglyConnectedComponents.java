package graph.otherAlgos;

import java.util.*;

public class StronglyConnectedComponents {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        adj.add(new ArrayList<>(Arrays.asList(2, 3))); // 0
        adj.add(new ArrayList<>(Arrays.asList(0)));    // 1
        adj.add(new ArrayList<>(Arrays.asList(1)));    // 2
        adj.add(new ArrayList<>(Arrays.asList(4)));    // 3
        adj.add(new ArrayList<>());                    // 4

        System.out.println("strongly connected components -- "+kosaraju(adj));
    }

    public static int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        //STEP 1 :: store the topo sort in the stack
        boolean[] isVisited = new boolean[adj.size()];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<adj.size();i++){
            if(isVisited[i]) continue;
            getTopoSortInStack(i,adj,stack,isVisited);
        }
        //STEP 2 :: reverse the edges
        List<List<Integer>> reverseAdj = getReverseAdj(adj);
        //STEP 3 :: traverse the DFS and count the scc
        int scc = 0;
        Arrays.fill(isVisited,false);
        int u = -1;
        while(!stack.isEmpty()){
            u = stack.pop();
            if(isVisited[u]) continue;
            dfs(u,reverseAdj,isVisited);
            scc++;
        }
        return scc;
    }

    private static List<List<Integer>> getReverseAdj(ArrayList<ArrayList<Integer>> adj){
        List<List<Integer>> reverseAdj = new ArrayList<>();
        for(int i=0;i<adj.size();i++)
            reverseAdj.add(new ArrayList<>());
        for(int u =0;u<adj.size();u++){
            for(int v : adj.get(u)){
                reverseAdj.get(v).add(u);
            }
        }
        return reverseAdj;
    }
    private static void getTopoSortInStack(int u,ArrayList<ArrayList<Integer>> adj, Deque<Integer> stack, boolean[] isVisited) {
        if(isVisited[u]) return;
        isVisited[u] = true;
        for(int v : adj.get(u)){
            if(isVisited[v]) continue;
            getTopoSortInStack(v,adj,stack,isVisited);
        }
        stack.push(u);
    }

    private static void dfs(int u,List<List<Integer>> adjList,boolean[] isVisited){
        if(isVisited[u]) return;
        isVisited[u] = true;
        for(int v : adjList.get(u)){
            if(isVisited[v]) continue;
            dfs(v,adjList,isVisited);
        }
    }

}
