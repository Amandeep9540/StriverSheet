package Arrays.Easy;

public class MissingNumber268 {
    public static void main(String[] args) {
        int missingNumber = missingNumberV2(new int[]{9,6,4,2,3,5,7,0,1});
        System.out.println("missingNumber  " +missingNumber);
    }

    /*
    * We can also use the formula  [ sum = n(n+1)/2
    * */
    public static int missingNumber(int[] nums) {
        int desiredSum = 0;
        int actualSum = 0;

        for(int i=0;i<nums.length;i++){
            actualSum += nums[i];
            desiredSum += i + 1;
        }

        return desiredSum - actualSum;
    }


    public static int missingNumberV2(int[] nums) {
        int actualSum = 0;

        for(int i=0;i<nums.length;i++){
            actualSum += nums[i];
        }

        int desiredSum = (nums.length *(nums.length +1))/2;
        return desiredSum - actualSum;
    }
}
