package binarysearch;

public class FindMinRotatedArr153 {
    public static void main(String[] args) {
        int[] arr = {5,6,7,1,2};
        int min = findMin(arr);
        System.out.println("minimum is -- "+min);
    }

    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while(start <= end){
            int mid = start + (end - start)/2;

            if(nums[start] <= nums[mid]){ //first half is sorted
                min = Math.min(min,nums[start]);
                start = mid + 1;
            }else{ // second half is sorted
                min = Math.min(min,nums[mid]);
                end = mid - 1;
            }
        }

        return min;
    }
}
