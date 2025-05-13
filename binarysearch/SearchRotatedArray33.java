package binarysearch;

public class SearchRotatedArray33 {
    public static void main(String[] args) {
        int[] arr = {7,6,5,4,3,2,9};
        System.out.println("index is -- "+search(arr,2));
    }

    public static int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while(end>=start){
            int mid = start + (end - start)/2;
            if(arr[mid] == target) return mid;
            //first half sorted the execute
            if(arr[start] <= arr[mid]){
                if(arr[start] <= target && arr[mid] >= target)
                    end = mid - 1;
                else
                    start = mid + 1;
            }else{
                if(arr[mid] < target && target <= arr[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }

        return -1; // ans doesn't exits
    }
}
