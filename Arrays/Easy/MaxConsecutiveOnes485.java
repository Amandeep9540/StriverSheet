package Arrays.Easy;

public class MaxConsecutiveOnes485 {
    public static void main(String[] args) {
        System.out.println("findMaxConsecutiveOnes is :: "+findMaxConsecutiveOnes(new int[]{0,0,0}));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int currentCon = 0;
        int maxCon = 0;

        int start = -1;

        for(int end = 0;end< nums.length;end++){
            if(nums[end] == 1){
                if(start == -1){
                    start = end;
                    currentCon++;
                }else{
                    currentCon++;
                }
            }else{
                start = -1;
                currentCon = 0;
            }
            maxCon = Math.max(currentCon,maxCon);
        }

        return maxCon;
    }
}
