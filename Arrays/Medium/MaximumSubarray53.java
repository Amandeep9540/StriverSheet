package Arrays.Medium;

public class MaximumSubarray53 {
    public static void main(String[] args) {
        int maxSum = maxSubArray(new int[]{-2,1});
        System.out.println("maxSum -- :: "+maxSum);
    }

    public static int maxSubArray(int[] arr) {

        int maxSum = arr[0];
        int currentSum = arr[0];

        for(int i=1;i<arr.length;i++){
            if(currentSum < 0)
                currentSum = 0;
            currentSum += arr[i];
            maxSum = Math.max(maxSum,currentSum);
        }

        return maxSum;
    }
}
