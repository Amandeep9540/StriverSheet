package graph.disjoint_union_set_dsu;

import java.util.*;

public class MakingLargeIsland827 {
    public static void main(String[] args) {
        int[][] grid = {{1,1},{1,1}};
        System.out.println("largest island == "+largestIsland(grid));
    }

    public static int largestIsland(int[][] grid) {
        int n = grid.length; // the matrix size will be nxn
        int[] parent = getParentArr(n*n);
        int[] rank = new int[n*n];
        boolean[][] isVisited = new boolean[n][n]; // this also means there is land

        for(int row =0;row<grid.length;row++){
            for(int col =0;col<grid[row].length;col++){
                if(isVisited[row][col] || grid[row][col] == 0) continue; // means water here skip
                isVisited[row][col] = true;
                int[] dirRow = {-1, 0, 1, 0};
                int[] dirCol = {0, 1, 0, -1};
                int parentId = row*n + col;
                for(int d=0;d<4;d++){
                    int newRow = row + dirRow[d];
                    int newCol = col + dirCol[d];
                    if(isValid(newRow,newCol,n,n) && grid[newRow][newCol] == 1){ // 1 means island
                        int newParentId = (newRow * n ) + newCol;
                        union(parentId,newParentId,parent,rank);
                    }
                }
            }
        }

        Map<Integer, Integer> parentMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    int root = find(i * n + j, parent);
                    parentMap.put(root, parentMap.getOrDefault(root, 0) + 1);
                }
            }
        }
        int maxCount = 0;
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col] == 1) continue; // means its already island we can't flip
                Set<Integer> uniqueParents = new HashSet<>();
                int[] dirRow = {-1, 0, 1, 0};
                int[] dirCol = {0, 1, 0, -1};

                for (int d = 0; d < 4; d++) {
                    int newRow = row + dirRow[d];
                    int newCol = col + dirCol[d];
                    if (isValid(newRow, newCol, n, n) && grid[newRow][newCol] == 1) {
                        uniqueParents.add(find(newRow * n + newCol, parent));
                    }
                }
                int count =0;
                for(int p : uniqueParents){
                    count += parentMap.get(p);
                }
                count++;
                maxCount = Math.max(count,maxCount);

            }
        }

        return maxCount == 0 ? n*n : maxCount;

    }

    private static boolean isValid(int newRow,int newCol,int totalRow, int totalCol){
        return newRow >=0 && newRow < totalRow && newCol >=0 && newCol < totalCol;
    }

    private static int[] getParentArr(int n){
        int[] parent = new int[n];
        for(int i=0;i<parent.length;i++)
            parent[i] = i;
        return parent;
    }

    private static int find(int x,int[] parent){
        if(x == parent[x]) return x;
        int x_parent = find(parent[x],parent);
        parent[x] = x_parent;
        return x_parent;
    }

    private static void union(int x, int y,int[] parent,int[] rank){
        int x_parent = find(x,parent);
        int y_parent = find(y,parent);
        if(x_parent == y_parent) return;
        if(rank[x_parent] == rank[y_parent]){
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }else if(rank[x_parent] < rank[y_parent]){
            parent[x_parent] = y_parent;
        }else{
            parent[y_parent] = x_parent;
        }

    }
}
