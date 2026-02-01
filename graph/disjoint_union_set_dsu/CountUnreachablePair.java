package graph.disjoint_union_set_dsu;

import java.util.*;

public class CountUnreachablePair {
    public static void main(String[] args) {
        int[][] edges = {{0,2},{0,5},{2,4},{1,6},{5,4}};
        int n = 7;
        System.out.println("pairs that are not connected -- "+countPairs(n,edges));
    }

    public static long countPairs(int n, int[][] edges) {
        int[] parent = new int[n];
        for(int i=0;i<n;i++)
            parent[i] = i;
        int[] rank = new int[n];
        for(int i=0;i<edges.length;i++){
            merge(edges[i][0],edges[i][1],parent,rank);
        }

        return getCountOfNotConnectedPair(parent,n);
    }

    private static void merge(int x,int y,int[] parent, int[] rank){
        int x_parent = find(x,parent);
        int y_parent = find(y,parent);
        if(x_parent == y_parent) return;
        if(rank[x_parent] == rank[y_parent]){
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }else if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        }else{
            parent[x_parent] = y_parent;
        }

    }

    private static int find(int x, int[] parent){
        if(x == parent[x]) return x;
        int x_parent = find(parent[x],parent);
        parent[x] = x_parent;
        return x_parent;
    }

    private static long getCountOfNotConnectedPair(int[] parent, int n){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<parent.length;i++){
            int iParent = find(i,parent);
            map.put(iParent, map.getOrDefault(iParent,0)+1);
        }
        long countOfNotConnectedPair = 0L;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int groupParent = entry.getKey();
            int connectedCom = entry.getValue();
            countOfNotConnectedPair += (long) connectedCom * (n-connectedCom);
        }
        return countOfNotConnectedPair/2;
    }
}
