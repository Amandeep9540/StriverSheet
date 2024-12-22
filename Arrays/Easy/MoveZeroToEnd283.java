package Arrays.Easy;

import java.util.Arrays;

public class MoveZeroToEnd283 {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        moveZeroV2(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void moveZeroes(int[] nums) {

        if(nums.length <= 1)
            return;

        int zeroIn = getZeroIndex(nums,0,nums.length-1);
            if(zeroIn == -1) return;
        int nonZeroIn = getNonZeroIndex(nums,zeroIn+1,nums.length-1);

                //check the condition
        if(zeroIn == -1 || zeroIn > nonZeroIn)
            return;

        while((nonZeroIn < nums.length) && (nonZeroIn != -1 && zeroIn != -1)){
            int temp = nums[zeroIn];
            nums[zeroIn] = nums[nonZeroIn];
            nums[nonZeroIn] = temp;

            zeroIn = getZeroIndex(nums,zeroIn+1,nums.length-1);
            nonZeroIn = getNonZeroIndex(nums,zeroIn+1, nums.length-1);
        }

    }

    public static int getZeroIndex(int[] arr,int start, int end){
        while (start <= end){
            if(arr[start] == 0)
                return start;
            start++;
        }
        return -1;
    }

    public static int getNonZeroIndex(int[] arr,int start, int end){
        while (start <= end && (start >= 0 && end < arr.length)){
            if(arr[start] != 0)
                return start;
            start++;
        }
        return -1;
    }

        /*
        * This version is good in term of complexity and code complexity
        * */
    public static void moveZeroV2(int[] nums){
        int zeroIn = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                zeroIn = i;
                break;
            }
        }

            if(zeroIn == -1) return;

       for(int nonZeroIn = zeroIn+1;nonZeroIn<nums.length;nonZeroIn++){
           if(nums[nonZeroIn] != 0){
               nums[zeroIn] = nums[nonZeroIn];
               nums[nonZeroIn] = 0;
               zeroIn++;
           }
       }
    }
}
