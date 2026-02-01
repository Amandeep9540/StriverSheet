package graph.disjoint_union_set_dsu;

import java.util.List;
import java.util.*;

public class NoOfIsland2_GFG {
    public static void main(String[] args) {
        NoOfIsland2_GFG question = new NoOfIsland2_GFG();
        int rows = 4;
        int cols = 5;
        int[][] operators = {{1,1},{0,1},{3,3},{3,4}};
        List<Integer> island = question.numOfIslands(rows,cols,operators);
        System.out.println(island);
    }

    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {

        DSU dsu = new DSU();
        boolean[][] isVisited = new boolean[rows][cols];
        List<Integer> result = new ArrayList<>();
        int count = 0;
        for(int[] op : operators){
            int curr_row = op[0];
            int curr_col = op[1];
            if(isVisited[curr_row][curr_col]){ result.add(count); continue;}
            isVisited[curr_row][curr_col] = true;
            count++;
            // row -1 , col -- upwards
            // row, col+1 -- rightwards
            // row+1, col -- downwards
            // row,col-1 -- leftwards
            int[] rowDir = {-1,0,1,0};
            int[] colDir = {0,1,0,-1};

            for(int i=0;i<4;i++){
                int newRow = curr_row + rowDir[i];
                int newCol = curr_col + colDir[i];
                if(isValid(newRow,newCol,rows,cols)){
                    int newNode = newRow * cols + newCol;
                    int curr_node = curr_row * cols + curr_col;
                    if(dsu.find(newNode) != dsu.find(curr_node) && isVisited[newRow][newCol]){
                        count--;
                        dsu.union(newNode,curr_node);
                    }
                }
            }
            result.add(count);
        }
        return result;
    }

    private boolean isValid(int curr_row,int curr_col,int totalRow,int totalCol){
        return curr_row >= 0 && curr_row < totalRow && curr_col >=0 && curr_col < totalCol;
    }

    private class DSU{
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer, Integer> rank = new HashMap<>();


        public int find(int x){
            if(map.containsKey(x)){
                if(x == map.get(x)) return x;
                int x_parent = find(map.get(x));
                map.put(x,x_parent); // Path compression
            }else{
                map.put(x,x);
                rank.put(x, 0);
            }
            return map.get(x);
        }

        public void union(int x, int y){
            int x_parent = find(x);
            int y_parent = find(y);
            if(x_parent == y_parent) return;

            //now we are merging
            if(rank.get(x_parent) == rank.get(y_parent)){
                map.put(x_parent,y_parent);
                rank.put(y_parent,map.get(y_parent)+1);
            }else if(rank.get(x_parent) < rank.get(y_parent))
                map.put(x_parent,y_parent);
            else
                map.put(y_parent,x_parent);
        }
    }
}
