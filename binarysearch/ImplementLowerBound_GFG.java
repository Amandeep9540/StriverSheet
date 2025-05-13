package binarysearch;

public class ImplementLowerBound_GFG {
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 10, 11, 11, 25};
        System.out.println("lower bound -- "+lowerBound(arr,11));
    }

    public  static int lowerBound(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int ans = arr.length;

        while(start <= end){
            int mid =start + (end - start) / 2;

            if(arr[mid] >= target){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return ans;
    }
}
