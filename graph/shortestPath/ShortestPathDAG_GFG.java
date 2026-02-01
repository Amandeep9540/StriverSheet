package graph.shortestPath;

import java.util.*;

public class ShortestPathDAG_GFG {
    public static void main(String[] args) {
        int V = 6;
        int E = 7;

        int[][] edges = {
                {0, 1, 2},
                {0, 4, 1},
                {4, 5, 4},
                {4, 2, 2},
                {1, 2, 3},
                {2, 3, 6},
                {5, 3, 1}
        };

        int[] dis = shortestPath(V,E,edges);
        for(int i=0;i<dis.length;i++){
            System.out.print(" "+dis[i]);
        }
    }

    public static int[] shortestPath(int V, int E, int[][] edges) {
        List<List<VertexWt<Integer,Integer>>> adjList = getAdjList(edges,V);
        //STEP 1 :: find the topo sort
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] isVisited = new boolean[V];
        for(int i=0;i<V;i++){
            if(isVisited[i]) continue;
            topoSort(i,adjList,stack,isVisited);
        }
        //STEP 2 :: relax the edges
        int[] dis = new int[V];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[0] = 0;
        while(!stack.isEmpty()){
            int u = stack.pop();
            for(VertexWt<Integer,Integer> p : adjList.get(u)) {
                dis[p.edge] =(int) Math.min(dis[p.edge],(long) dis[u] +(long) p.wt);
            }
        }
        for(int i =0;i<V;i++){
            if(dis[i] == Integer.MAX_VALUE){
                dis[i] = -1;
            }
        }

        return dis;
    }

    private static List<List<VertexWt<Integer,Integer>>> getAdjList(int[][] edges,int V){
        List<List<VertexWt<Integer,Integer>>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            // u --> v
            adjList.get(u).add(new VertexWt<Integer,Integer>(v,wt));
        }
        return adjList;
    }

    private static void topoSort(int u,List<List<VertexWt<Integer,Integer>>> adjList,Deque<Integer> stack,boolean[] isVisited){
        isVisited[u] = true;
        for(VertexWt<Integer,Integer> p : adjList.get(u)){
            if(isVisited[p.edge]) continue;
            topoSort(p.edge,adjList,stack,isVisited);
        }
        stack.push(u);
    }

}

class VertexWt<A,B>{
    A edge;
    B wt;
    VertexWt(A edge,B wt){
        this.edge = edge;
        this.wt = wt;
    }
}