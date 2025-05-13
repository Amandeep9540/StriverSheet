package slidingwindow;

public class NiceSubarray1248 {
    public static void main(String[] args) {
        int[] arr  = {2,2,2,1,2,2,1,2,2,2};
        System.out.println("maximum length is :: "+numberOfSubarrays(arr,2));
    }

    public static int numberOfSubarrays(int[] nums, int goal) {
        int windowStart = 0;
        int countEven = 0;
        int result = 0;
        int windowSum = 0;

        for(int windowEnd = 0; windowEnd<nums.length;windowEnd++){
            windowSum += nums[windowEnd]%2;

            while(windowStart<windowEnd && (nums[windowStart]%2 == 0 || windowSum > goal)){
                if(nums[windowStart]%2 == 0)
                    countEven++;
                else
                    countEven = 0;

                windowSum -= nums[windowStart]%2;
                windowStart++;
            }

            if(windowSum == goal)
                result += 1 + countEven;
        }

        return result;
    }
}
