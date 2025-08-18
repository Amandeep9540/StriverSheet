package dp.dp_2D_3D;
import java.util.*;

public class Triangle120 {
    public static void main(String[] args) {
        Triangle120 question = new Triangle120();
        //int minSumPath = question.minimumTotal(getTrianlgeList());
//        int minSumPath = question.minimumTotalTabulation(getTrianlgeList());
        int minSumPath = question.minimumTotalTabulationOptimized(getTrianlgeList());
        System.out.println("Minimum Path Sum ==>>" +minSumPath);
    }
             //Memoization
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int result = Integer.MAX_VALUE;
        int row = triangle.size()-1;
        for(int i=0;i<triangle.size();i++){
            result = Math.min(result,minimumTotal(triangle,row,i,dp));
        }
        return result;
    }

    public int minimumTotal(List<List<Integer>> triangle,int row, int col,int[][] dp){
                //base condition
        if(row < col || row < 0 || col < 0) return Integer.MAX_VALUE;
        if(row == 0) return triangle.get(0).get(0);
                //dp check
        if(dp[row][col] != Integer.MAX_VALUE) return dp[row][col];
                //recursion call
        int upper = minimumTotal(triangle,row-1,col,dp);
        int upperDiagnoal = minimumTotal(triangle,row-1,col-1,dp);
                //dp store
        dp[row][col] = triangle.get(row).get(col) + Math.min(upper,upperDiagnoal);
        return dp[row][col];
    }
                //Tabulation
    public int minimumTotalTabulation(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = triangle.get(0).get(0);
        int n = triangle.size() -1 ;
        int result = Integer.MAX_VALUE;
            for(int row = 0; row <= n; row++){
                for(int col = 0; col <= row; col++){
                    if(row == 0 && col == 0) continue;
                    int upper = dp[row-1][col];
                    int upperDiagnoal = col <= 0 ? Integer.MAX_VALUE : dp[row-1][col-1];
                    dp[row][col] = triangle.get(row).get(col) + Math.min(upper,upperDiagnoal);
                        if(row == n) result = Math.min(result,dp[row][col]);
                }
            }
        return result;
    }

                //Tabulation + Space Optimization
    public int minimumTotalTabulationOptimized(List<List<Integer>> triangle) {
        if(triangle.size() == 1) return triangle.get(0).get(0);
        int[] dp = new int[triangle.size()];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = triangle.get(0).get(0);
        int n = triangle.size() -1 ;
        int result = Integer.MAX_VALUE;
        int prev = Integer.MAX_VALUE;
        for(int row = 0; row <= n; row++){
            for(int col = 0; col <= row; col++){
                if(row == 0 && col == 0) continue;
                    int upper = dp[col];
                    int upperDiagnoal = prev;
                prev = dp[col];
                dp[col] = triangle.get(row).get(col) + Math.min(upper,upperDiagnoal);
                if(row == n) result = Math.min(result,dp[col]);
            }
        }
        return result;
    }

    public static List<List<Integer>> getTrianlgeList(){
        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        return triangle;
    }
}
