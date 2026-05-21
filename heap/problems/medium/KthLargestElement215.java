package heap.problems.medium;

import heap.learning.Heap;

public class KthLargestElement215 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println("-- "+findKthLargest(nums,k));
    }

    public static int findKthLargest(int[] nums, int k) {
        Heap<Integer> heap = new Heap<>();
        for(int i=0;i<nums.length;i++){
            heap.insert(nums[i]);
            if(heap.size() > k)
                heap.delete();
        }

        return heap.top();
    }



    public static int findKthLargestV1(int[] nums, int k) {
        if(nums.length == 1) return k == 1 ? nums[0] : -1;
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int pivotIdx = quickSelectAlgo(nums,left,right,left);
            if(pivotIdx == k-1) return nums[pivotIdx];
            if(pivotIdx < (k - 1))
                left = pivotIdx + 1;
            else
                right = pivotIdx - 1;
        }

        return -1;
    }

    public static int quickSelectAlgo(int[] nums, int left, int right, int pivotIdx){
        left = left + 1;
        int pivot = nums[pivotIdx];
        while(left <= right){
            if(nums[left] < pivot && nums[right] > pivot){
                swap(nums,left,right);
                left++;right--;
            }
            if(nums[left] >= pivot){
                left++;
            }
            if(nums[right] <= pivot)
                right--;
        }
        swap(nums,pivotIdx,right);
        return right;
    }

    public static void swap(int[] nums, int idx1, int idx2){
        int temp = nums[idx1];
        nums[idx1] =  nums[idx2];
        nums[idx2] = temp;
    }
}
