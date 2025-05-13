package binarysearch;

public class SearchInsertPosition35 {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        System.out.println("insert index -- "+searchInsert(arr,2));
    }

    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = nums.length;

        while(end >= start){
            int mid = start + (end - start)/2;

            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return ans;
    }
}
