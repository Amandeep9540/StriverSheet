package binarysearch;

public class SingleEleInSortedArr540 {
    public static void main(String[] args) {
        int[] arr = {1,1,5,5,6,9,9};
        System.out.println("single element will be -- "+singleNonDuplicate(arr));
    }

    public static int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            // Make mid even for comparison
            if (mid % 2 == 1) {
                mid--;
            }

            // Compare pair: if nums[mid] == nums[mid + 1], unique is in right half
            if (nums[mid] == nums[mid + 1]) {
                start = mid + 2;
            } else {
                end = mid;
            }
        }

        return nums[start];
    }
}
