package graph.problems;

import java.util.*;

public class _01Matrix542 {
    public static void main(String[] args) {
        int[][] mat = {
                {0,0,0},{0,1,0},{1,1,1}
        };
        int[][] updatedMatrix = updateMatrix(mat);
        for(int i=0;i<updatedMatrix.length;i++){
            for(int j=0;j<updatedMatrix[i].length;j++){
                System.out.print(updatedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] updateMatrix(int[][] mat) {
        Queue<List<Integer>> queue = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[mat.length][mat[0].length];
        //filling the queue and then we check if the neighbour is non-zero we can give the dis by curr.get(2) + 1
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == 0){ // we can start our jounery form here
                    queue.offer(List.of(i,j,0));
                    isVisited[i][j] = true;
                }
            }
        }
        while(!queue.isEmpty()){
            List<Integer> curr = queue.poll();
            int row = curr.get(0);
            int col = curr.get(1);
            int dis = curr.get(2);
            //going upwards
            if(row-1 >= 0 && !isVisited[row-1][col]){
                mat[row-1][col] = dis+1;
                isVisited[row-1][col] = true;
                queue.offer(List.of(row-1,col,dis+1));
            }
            //going downwards
            if(row+1 < mat.length && !isVisited[row+1][col]){
                mat[row+1][col] = dis+1;
                isVisited[row+1][col] = true;
                queue.offer(List.of(row+1,col,dis+1));
            }
            //going left
            if(col-1 >= 0 && !isVisited[row][col-1]){
                mat[row][col-1] = dis+1;
                isVisited[row][col-1] = true;
                queue.offer(List.of(row,col-1,dis+1));
            }
            //going left
            if(col+1 < mat[row].length && !isVisited[row][col+1]){
                mat[row][col+1] = dis+1;
                isVisited[row][col+1] = true;
                queue.offer(List.of(row,col+1,dis+1));
            }
        }

        return mat;
    }

}
