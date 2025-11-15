package dp.dpOnSquares;

public class CountSqSubmatrices1277 {
    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,1,1},
                {1,1,1,1},
                {0,1,1,1}
        };
        System.out.println("Maximum square -- "+countSquares(matrix));
    }
    public static int countSquares(int[][] matrix) {
        int sum =0;
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[i].length;j++){
                if(matrix[i][j] == 0) continue;
                int min = Math.min(matrix[i-1][j],Math.min(matrix[i-1][j-1],matrix[i][j-1]));
                matrix[i][j] += min;
                sum += matrix[i][j];
            }
        }

        for(int i=0;i<matrix[0].length;i++){
            sum += matrix[0][i];
        }
        for(int i=1;i<matrix.length;i++){
            sum += matrix[i][0];
        }
        return sum;
    }
}
