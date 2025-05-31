package binarysearch.two_DArray;

public class Search2DMatrix74 {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        System.out.println("is element present --> "+searchMatrix(matrix,3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int low = 0, high = matrix.length-1;

        while(high >= low){
            int mid = (low + high)/2;
            if(matrix[mid][0] <= target && matrix[mid][matrix[mid].length -1] >= target){
                if(matrix[mid][0] == target || matrix[mid][matrix[mid].length -1] == target) return true;
                return isTargetExist(matrix[mid],target);
            }else if(matrix[mid][0] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return false;
    }

    public static boolean isTargetExist(int[] arr,int target){
        int low = 0, high = arr.length -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target) return true;
            else if(arr[mid] > target) high = mid -1;
            else low = mid + 1;
        }
        return false;
    }
}
