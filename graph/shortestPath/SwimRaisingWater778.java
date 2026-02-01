package graph.shortestPath;

import java.util.PriorityQueue;

public class SwimRaisingWater778 {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2, 3, 4},
                {24, 23, 22, 21, 5},
                {12, 13, 14, 15, 16},
                {11, 17, 18, 19, 20},
                {10, 9, 8, 7, 6}
        };
        System.out.println("time needed -- "+swimInWater(matrix));
    }

        /// Time complexity -- O(n(log n))
    public static int swimInWater(int[][] grid) {
        int n =grid.length;
        // How the Dijkstra will work here
        boolean[][] isVisited = new boolean[n][n];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->a[0] - b[0]);
        queue.offer(new int[]{grid[0][0],0,0});
        isVisited[0][0] = true;
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            int row = arr[1];int col = arr[2];
            max = Math.max(max,arr[0]);
            if(row == (n-1) && col == (n-1)) return max;

            int[] dirRow = {-1, 0, 1, 0};
            int[] dirCol = {0, 1, 0, -1};

            for(int d=0;d<4;d++){
                int newRow = row + dirRow[d]; int newCol = col + dirCol[d];
                if(isValid(newRow,newCol,n,n) && !isVisited[newRow][newCol]){
                    isVisited[newRow][newCol] = true;
                    queue.offer(new int[]{grid[newRow][newCol],newRow,newCol});
                }
            }
        }

        return -1;
    }

    private static boolean isValid(int newRow,int newCol,int totalRow, int totalCol){
        return newRow >=0 && newRow < totalRow && newCol >=0 && newCol < totalCol;
    }
}
