package binarysearch.medium;

public class SmallestDivisorThenThreshold1283 {
    public static void main(String[] args) {
        int[] arr = {1,2,5,9};
        System.out.println("smallestDivisor -- "+smallestDivisor(arr,6));
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = Integer.MIN_VALUE;
        for(int ele : nums){
            end = Math.max(ele,end);
        }

        int smallestDivisor = Integer.MAX_VALUE;

        while(end >= start){
            int mid = start + (end - start)/2;

            if(isAfterDividingLesserThanThreshold(nums,mid,threshold)){
                smallestDivisor = Math.min(smallestDivisor,mid);
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return smallestDivisor;
    }

    public static boolean isAfterDividingLesserThanThreshold(int[] arr,int divisor,int threshold){
        int sum = 0;
        for(int ele : arr){
            sum += Math.ceil(ele/(double)divisor);
        }
        return threshold >= sum;
    }
}
