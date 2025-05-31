package binarysearch.two_DArray;

public class FindPeak1901 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,4},
                {3,2}
        };

        int[] result = findPeakGrid(matrix);
        System.out.println(" -- "+result[0] + " -- "+result[1]);
    }

    public static int[] findPeakGrid(int[][] mat) {
        int low = 0, high = mat[0].length -1;
        int[] result = new int[2];
        while(low <= high){
            int mid = (low+high)/2;
            int maxEle = findMax(mat,mid);
            if(
                    ( (mid == 0) || (mat[maxEle][mid] > mat[maxEle][mid-1])) &&
                            ( (mid == mat[0].length -1) || (mat[maxEle][mid] > mat[maxEle][mid+1]))
            ){
                result[0] = maxEle;
                result[1] = mid;
                return result;
            }else if(mid != 0 && mat[maxEle][mid] < mat[maxEle][mid-1]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return result;
    }

    public static int findMax(int[][] matrix,int col){
        int max = 0;
        for(int i=1;i<matrix.length;i++){
            if(matrix[i][col] > matrix[max][col]){
                max = i;
            }
        }
        return max;
    }
}
