package Arrays.Medium;

public class SetMatrixZero73 {
    public static void main(String[] args) {
        int[][] matrix= {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
    }

    public static void setZeroes(int[][] matrix) {
        boolean isFirstColZero = false;
        boolean isFirstRowZero = false;

        for (int i=0;i<matrix[0].length;i++){
            if(matrix[0][i] == 0){
                isFirstRowZero = true;
                break;
            }
        }

        for (int i=0;i<matrix.length;i++){
            if(matrix[i][0] == 0){
                isFirstColZero = true;
                break;
            }
        }

        for(int i=1;i<matrix.length;i++){
            for(int j=1;j< matrix[i].length;j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i=1;i< matrix[0].length;i++){
            if(matrix[0][i] == 0){
                for(int j = 1;j< matrix.length;j++){
                    matrix[j][i] = 0;
                }
            }
        }

        for(int i=1;i< matrix.length;i++){
            if(matrix[i][0] == 0){
                for(int j = 1;j< matrix[0].length;j++){
                    matrix[i][j] = 0;
                }
            }
        }

        if(isFirstColZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        if(isFirstRowZero) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }

}
