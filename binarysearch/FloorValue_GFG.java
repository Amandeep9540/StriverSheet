package binarysearch;

public class FloorValue_GFG {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        System.out.println("floor index -- "+findFloor(arr,11));
    }

    static int findFloor(int[] arr, int x) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(arr[mid] <= x){
                ans = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return ans;
    }
}
