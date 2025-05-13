package binarysearch;

public class BinarySearch704 {
    public static void main(String[] args) {
        int[] arr = {2,5,8,11,23,28};
        System.out.println("index of 5 is -- "+ search(arr,5));
    }

    public static int search(int[] nums, int target) {
        int targetInd = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start+end)/2;
            if(nums[mid] > target)
                end = mid -1;
            else if(nums[mid] < target)
                start = mid + 1;
            else{
                targetInd = mid;
                break;
            }
        }
        return targetInd;
    }
}
