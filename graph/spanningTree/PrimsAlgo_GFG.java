package graph.spanningTree;

import java.util.*;

public class PrimsAlgo_GFG {
    public static void main(String[] args) {
        PrimsAlgo_GFG question = new PrimsAlgo_GFG();

        int[][] edges= {{0, 1, 5}, {1, 2, 3}, {0, 2, 1}};
        System.out.println("min spanning tree cost -- "+question.spanningTree(3,edges));
    }

    public int spanningTree(int V, int[][] edges) {
        boolean[] inMst = new boolean[V];
        List<List<int[]>> adjList = getAdjList(V,edges);
        int[] parent = new int[V];
        Arrays.fill(parent,-1); // parent is not required in this question
        PriorityQueue<Tuple> queue = new PriorityQueue<>((a,b)->a.cost - b.cost);
        queue.offer(new Tuple(-1,0,0));// parent,cost,node


        int sum = 0;
        while(!queue.isEmpty()){
            Tuple t = queue.poll();
            if(inMst[t.node]) continue;
            sum += t.cost;
            inMst[t.node] = true;
            for(int[] adjV :adjList.get(t.node)){
                if(inMst[adjV[0]]) continue;
                queue.offer(new Tuple(t.node,adjV[1],adjV[0]));
            }
        }

        return sum;
    }

    private List<List<int[]>> getAdjList(int V, int[][] edges){
        List<List<int[]>> adjList = new ArrayList<>(V);
        for(int i=0;i<V;i++)
            adjList.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];int v = edges[i][1]; int wt = edges[i][2];
            adjList.get(u).add(new int[]{v,wt});
            adjList.get(v).add(new int[]{u,wt});
        }
        return adjList;
    }

    private class Tuple{
        int parent;
        int cost;
        int node;
        Tuple(int parent,int cost,int node){
            this.parent = parent;
            this.cost = cost;
            this.node = node;
        }
    }

}
