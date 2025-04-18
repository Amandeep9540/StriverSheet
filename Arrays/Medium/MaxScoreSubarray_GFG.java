package Arrays.Medium;

public class MaxScoreSubarray_GFG {
    public static void main(String[] args) {
        int[] arr = {228,394,463,227,388,757,782,238,967};
        System.out.println("Pair Max Sum :: "+pairWithMaxSum(arr));
    }

    public static int pairWithMaxSum(int arr[]) {
        int maximumSum = 0;
        for(int i = 0;i<arr.length-1;i++){
            maximumSum = Math.max(arr[i], arr[i+1]);
        }

        return maximumSum;
    }
}
