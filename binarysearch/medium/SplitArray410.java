package binarysearch.medium;

public class SplitArray410 {
    public static void main(String[] args) {
        int[] arr = {2,3,1,1,1,1,1};
        System.out.println("-->" +splitArrayv2(arr,5));
    }

    /*use linear*/
    public static int splitArray(int[] nums, int k) {
        int high = 0;
        int low = Integer.MIN_VALUE;
        for(int ele:nums){
            low = Math.max(low,ele);
            high += ele;
        }
        if(k == 1) return high;
        if(k == nums.length) return low;
        int ans = -1;
        for(int i=low;i<=high;i++){
            int count = countSubArrayWithSum(nums,i);
            if(count <= k){
                return i;
            }
        }
        return ans;
    }

    /*use binary -- O(nlogn)*/
    public static int splitArrayv2(int[] nums, int k) {
        int high = 0;
        int low = Integer.MIN_VALUE;
        for(int ele:nums){
            low = Math.max(low,ele);
            high += ele;
        }
        if(k == 1) return high;
        if(k == nums.length) return low;
        while(high >= low){
            int mid = (low + high)/2;
            int count = countSubArrayWithSum(nums,mid);
            if(count > k)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    public static int countSubArrayWithSum(int[] nums,int requiredSubArrSum){
        int currSum = 0;
        int subArrayCount = 1;
        for(int i=0;i<nums.length;i++){
            if((currSum + nums[i]) < requiredSubArrSum){
                currSum = nums[i];
                subArrayCount++;
            }else{
                currSum += nums[i];
            }
        }
        return subArrayCount;
    }
}
