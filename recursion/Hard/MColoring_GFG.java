package recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class MColoring_GFG {
    public static void main(String[] args) {

    }

    static boolean graphColoring(int v, List<int[]> edges, int m) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); // Since the graph is undirected
        }
        int[] color = new int[v];
       return isColoringPossible(0,adj,v,color,m);
    }

    static boolean isColoringPossible(int currentNode,List<List<Integer>> edges,int v,int[] colorIndex,int color){
        if(currentNode == v){
            return true;
        }
        for(int i=1;i<=color;i++){
            if(isColoringSafe(currentNode,edges,i,colorIndex)){
                colorIndex[currentNode] = i;
                if(isColoringPossible(currentNode+1,edges,v,colorIndex,color)){
                    return true;
                }
                colorIndex[currentNode] = 0;
            }
        }
        return false;
    }

    private static boolean isColoringSafe(int currentNode, List<List<Integer>> edges, int color,int[] colorArray) {
        for(int neighbor: edges.get(currentNode)){
            if(colorArray[neighbor] == color) return false;
        }
        return true;
    }
}
