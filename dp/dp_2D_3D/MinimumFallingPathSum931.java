package dp.dp_2D_3D;

public class MinimumFallingPathSum931 {
    public static void main(String[] args) {
        MinimumFallingPathSum931 question = new MinimumFallingPathSum931();
            int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
//        int minSum = question.minFallingPathSum(matrix);
        int minSum = question.minFallingPathSumTabulationOptimized(matrix);
        System.out.println("min sum ==> "+minSum);
    }

                //Memoization TC - O(m*n) without DP(3^n) SC - O(m*n) without DP O(n)
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
                    //fill the dp with the maximum
        for(int i=0;i<dp.length;i++)
            java.util.Arrays.fill(dp[i],Integer.MAX_VALUE);
        int result = Integer.MAX_VALUE;
        int lastRow = matrix.length - 1;
        for(int i=0;i<matrix[0].length;i++){
            result = Math.min(result,minFallingPathSum(matrix,lastRow,i,dp));
        }
        return result;
    }
    public int minFallingPathSum(int[][] matrix,int row, int col, int[][] dp){
                        //base conditions
        if((row == 0) && (col >= 0 && col < matrix[row].length)){   // you reached to top row! GREAT
            return matrix[row][col];
        }
        if((col < 0) || col >= matrix[row].length){ // Invalid case ! OOPS
            return Integer.MAX_VALUE;
        }
                    //check the dp array
        if(dp[row][col] != Integer.MAX_VALUE) return dp[row][col];
                    // recursion calls
        int upper = minFallingPathSum(matrix,row - 1, col, dp);
        int leftDiagonal = minFallingPathSum(matrix,row - 1, col - 1, dp);
        int rightDiagonal = minFallingPathSum(matrix,row - 1, col + 1, dp);
                    // checkin the min ans
        dp[row][col] = matrix[row][col] + Math.min(upper,Math.min(leftDiagonal,rightDiagonal));
        return dp[row][col];
    }

                // Tabulation TC - O(m*n) + O(m*n) SC - O(m*n)
    public int minFallingPathSumTabulation(int[][] matrix) {
        int result = Integer.MAX_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix[0].length;i++){
                dp[0][i] = matrix[0][i];
                result = Math.min(result, dp[0][i]);
        }
                //fill the dp with the maximum
        for(int i=1;i<dp.length;i++)
            java.util.Arrays.fill(dp[i],Integer.MAX_VALUE);

        int lastRow = matrix.length - 1;
                //main logic ! CheckOut
            for(int row=1; row< matrix.length ;row++){
                result = Integer.MAX_VALUE;
                for(int col = 0; col<matrix[row].length;col++){
                        int upper = dp[row - 1][col];
                        int leftDiagonal = (col - 1) < 0 ? Integer.MAX_VALUE :  dp[row - 1][col - 1];
                        int rightDiagonal = (col + 1) >= matrix[row].length ? Integer.MAX_VALUE : dp[row - 1][col + 1];
                    int currSum = matrix[row][col] + Math.min(upper,Math.min(leftDiagonal,rightDiagonal));
                    dp[row][col] = currSum;
                    if(row == lastRow)
                        result = Math.min(result,currSum);
                }
            }
        return result;
    }

                //Tabulation + Space Optimization TC - O(m) + O(m*n)  + SC - O(m) where n = row, m = col
    public int minFallingPathSumTabulationOptimized(int[][] matrix) {
        int result = Integer.MAX_VALUE;
        int[] dp = new int [matrix[0].length];
        for(int i=0;i<matrix[0].length;i++){
            dp[i] = matrix[0][i];
            result = Math.min(result, dp[i]);
        }

        int lastRow = matrix.length - 1;
        int prevLeftDiagonal = Integer.MAX_VALUE;
                //main logic ! CheckOut
        for(int row=1; row< matrix.length ;row++){
                result = Integer.MAX_VALUE;
                prevLeftDiagonal = Integer.MAX_VALUE;
            for(int col = 0; col<matrix[row].length;col++){
                    int upper = dp[col];
                    int leftDiagonal = prevLeftDiagonal;
                    int rightDiagonal = (col + 1) >= matrix[row].length ? Integer.MAX_VALUE : dp[col + 1];
                    int currSum = matrix[row][col] + Math.min(upper,Math.min(leftDiagonal,rightDiagonal));
                prevLeftDiagonal = dp[col];
                dp[col] = currSum;
                if(row == lastRow)
                    result = Math.min(result,currSum);
            }
        }
        return result;
    }
}
