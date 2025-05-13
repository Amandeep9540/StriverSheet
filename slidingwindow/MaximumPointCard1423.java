package slidingwindow;

import java.util.Arrays;

public class MaximumPointCard1423 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,1};
        System.out.println("Maximum score with this input is :: "+maxScore(arr,3));
    }
    public static int maxScore(int[] cardPoints, int k) {
        if(k >= cardPoints.length)
            return Arrays.stream(cardPoints).sum();

        int result = 0;
        int windowStart = 0;
        int currentSum = 0;

        while(windowStart<k){
            currentSum += cardPoints[windowStart++];
        }
        result = currentSum;

        int windowEnd = cardPoints.length;
        while( windowStart >= 0 && (cardPoints.length - windowEnd) < k){
            currentSum += cardPoints[--windowEnd];
            currentSum -= cardPoints[--windowStart];
            result = Math.max(currentSum,result);
        }

        return result;
    }
}
