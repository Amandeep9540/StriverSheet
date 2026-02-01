package graph.disjoint_union_set_dsu;

import java.util.ArrayList;
import java.util.List;

public class NumberProvinces547 {
    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        int provinces = findCircleNumV2(isConnected);
        System.out.println("No of province -- "+provinces);
    }

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] isVisited = new boolean[n];
        List<List<Integer>> adjList = getAdjacencyList(isConnected,n);
        int provincesCount = 0;
        for(int i=0;i<n;i++){
            if(isVisited[i]) continue;
            dfs(adjList,i,isVisited);
            provincesCount++;
        }
        return provincesCount;
    }

    public static void dfs(List<List<Integer>> adjList,int u,boolean[] isVisited){
        isVisited[u] = true;
        for(int v : adjList.get(u)){
            if(!isVisited[v])
                dfs(adjList,v,isVisited);
        }
    }

    public static int findCircleNumV2(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] isVisited = new boolean[n];
        //List<List<Integer>> adjList = getAdjacencyList(isConnected,n);
        int provincesCount = 0;
        for(int i=0;i<n;i++){
            if(isVisited[i]) continue;
            dfsV2(isConnected,i,isVisited);
            provincesCount++;
        }
        return provincesCount;
    }

    public static void dfsV2(int[][] adjList,int u,boolean[] isVisited){
        isVisited[u] = true;
        for(int v =0;v<adjList.length;v++){
            if(!isVisited[v] && adjList[u][v] == 1)
                dfsV2(adjList,v,isVisited);
        }
    }

    public static List<List<Integer>> getAdjacencyList(int[][] matrix, int n){
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<>());

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 1){
                    //populate the adjacency list
                    int u = i;
                    int v = j;
                    adjList.get(u).add(v);
                    adjList.get(v).add(u);
                }
            }
        }
        return adjList;
    }
}
