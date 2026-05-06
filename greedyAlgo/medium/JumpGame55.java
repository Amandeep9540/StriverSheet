package greedyAlgo.medium;

public class JumpGame55 {
    public static void main(String[] args) {
        int[] jumps = {3,2,1,0,4};
        System.out.println("can we reach -- "+canJump(jumps));
    }

    public static boolean canJump(int[] nums) {
        int maxIndex = 0;
        for(int i=0;i<nums.length;i++){
            //max index we can reach
            if(maxIndex < nums[i] + i){
                maxIndex = nums[i] + i;
            }


            //checking if the index value is zero then can we go to next index
            if(nums[i] == 0 && (i != nums.length -1) && (maxIndex <= i)) return false;

            if(maxIndex >= nums.length) return true;
        }

        return true;
    }
}
