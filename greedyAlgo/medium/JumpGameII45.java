package greedyAlgo.medium;

public class JumpGameII45 {
    public static void main(String[] args) {
        int[] jumps = {2,3,0,1,4};
        System.out.println("min jumps needed -- "+jump(jumps));
    }

    public static int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int left = 0, right = 0, jumps =0;
        while(right < nums.length){ //1. left,right = 0 2.left =1 right =2, 3.left 3, right =
            int maxNewRange = 0;
            for(int i=left;i<=right;i++){
                maxNewRange = Math.max(maxNewRange,nums[i] + i);
            }

            left = right + 1;
            right =  maxNewRange;
            jumps++;
            if(right >= nums.length-1) return jumps;
        }
        return jumps;
    }
}
