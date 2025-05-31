package binarysearch.two_DArray;

public class RowMax1s_GFG {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,1,1}, {0,0,1,1}, {1,1,1,1}, {0,0,0,0}};
        System.out.println("row no is --> "+ rowWithMax1s(matrix));
    }
    public static int rowWithMax1s(int arr[][]) {
        int maxIndex = -1;
        int minFirstIndex = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            int low = 0,high = arr[i].length-1;
            int first1Index = Integer.MAX_VALUE;
            while(high >= low){
                int mid = low + (high-low)/2;
                if(arr[i][mid] == 1){
                    first1Index = Math.min(first1Index,mid);
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }

            if(minFirstIndex > first1Index){
                minFirstIndex = first1Index;
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
