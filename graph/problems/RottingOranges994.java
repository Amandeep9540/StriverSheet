package graph.problems;
import java.util.*;

public class RottingOranges994 {
    public static void main(String[] args) {
        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        System.out.println("time required -- "+orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        Queue<List<Integer>> queue = new ArrayDeque<>();
        int freshOragens = 0;
        int rottedOranges = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(Arrays.asList(i, j, 0));
                } else if (grid[i][j] == 1) {
                    freshOragens++;
                }
            }
        }
        int minutes = 0;
        while (!queue.isEmpty()) {
            List<Integer> curr = queue.poll();
            int row = curr.get(0);
            int col = curr.get(1);
            minutes = curr.get(2);

            //checking if we can go upwards
            if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                queue.offer(List.of(row - 1, col, minutes + 1));
                grid[row - 1][col] = 2;
                rottedOranges++;
            }
            //checking if we can go downwards
            if (row + 1 < grid.length && grid[row + 1][col] == 1) {
                queue.offer(List.of(row + 1, col, minutes + 1));
                grid[row + 1][col] = 2;
                rottedOranges++;
            }

            //checking if we can go left
            if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                queue.offer(List.of(row, col - 1, minutes + 1));
                grid[row][col - 1] = 2;
                rottedOranges++;
            }
            //checking if we can go right
            if (col + 1 < grid[row].length && grid[row][col + 1] == 1) {
                queue.offer(List.of(row, col + 1, minutes + 1));
                grid[row][col + 1] = 2;
                rottedOranges++;
            }

        }
        return rottedOranges == freshOragens ? minutes : -1;
    }
}
