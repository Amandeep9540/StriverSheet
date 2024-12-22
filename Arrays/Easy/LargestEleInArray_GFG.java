package Arrays.Easy;

import java.util.Arrays;
import java.util.OptionalInt;

public class LargestEleInArray_GFG {
    public static void main(String[] args) {
        int largest = largest(new int[]{1, 8, 7, 56, 90});
        System.out.println("max"  + largest);
    }

    public static int largest(int[] arr) {
             //return Arrays.stream(arr).max().orElse(-1);   // -- stream --
       int max = Integer.MIN_VALUE;
       for(int value : arr){
           max = Math.max(max,value);
       }
       return max;
    }
}
