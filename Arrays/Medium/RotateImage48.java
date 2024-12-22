package Arrays.Medium;

public class RotateImage48 {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
    }


    public static void rotate(int[][] matrix) {

        for(int i=0;i<matrix.length;i++){
            for(int j=i;j < matrix[i].length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0;i< matrix.length;i++){
            int low = 0;
            int high = matrix[i].length -1 ;
            while(high>low){
                int temp = matrix[i][low];
                matrix[i][low] = matrix[i][high];
                matrix[i][high] = temp;
                high--;low++;
            }

        }
    }
}
