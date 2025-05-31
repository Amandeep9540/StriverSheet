package binarysearch.two_DArray;

public class MedianSortedArray_GFG {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}
        };
        System.out.println("-- > "+median(matrix));
    }
    public static int median(int matrix[][]) {
        int low = matrix[0][0];
        for(int i =0;i<matrix.length;i++){
            low = Math.min(low,matrix[i][0]);
        }

        int high = matrix[0][matrix[0].length - 1];
        for(int i =0;i<matrix.length;i++){
            high = Math.max(high,matrix[i][matrix[0].length - 1]);
        }
        int occurenceNeeded = (matrix.length * matrix[0].length)/2;
        while(high >= low){
            int mid = (low + high)/2;
            int countOfMid = findCount(matrix,mid);
            if(countOfMid <= occurenceNeeded)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }


    public static int findCount(int[][] matrix,int tar){
        int count = 0;
        for(int i=0;i<matrix.length;i++){
            int[] arr = matrix[i];
            int low = 0;
            int high = arr.length - 1;
            while(low <= high){
                int mid = (low + high)/2;
                if(arr[mid] <= tar)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            count += low;
        }
        return count;
    }
}
