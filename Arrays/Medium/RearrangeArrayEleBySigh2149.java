package Arrays.Medium;

import java.util.Arrays;

public class RearrangeArrayEleBySigh2149 {

    public static void main(String[] args) {
        int[] rearrangeArray = rearrangeArrayV2(new int[]{3, 1, -2, -5, 2, -4});
        for(int i=0;i< rearrangeArray.length;i++){
            System.out.print(" "+rearrangeArray[i]);
        }
        Arrays.stream(rearrangeArray).peek(System.out::println);// peek is intermediate operation and its should follow by terminal op like (count,foreach,collect).
    }

    public static int[] rearrangeArray(int[] nums) {
        int positiveInd = -1;
        int negativeInd = -1;

        for(int i=0;i< nums.length;i++) {

            int tempI = i;
            while((positiveInd == -1 || negativeInd ==-1) && tempI < nums.length){
                    if(nums[tempI] > 0 && positiveInd == -1){
                        positiveInd = tempI;
                    }else if(negativeInd == -1){
                        negativeInd = tempI;
                    }
                    tempI++;
            }

            if(positiveInd != -1 && negativeInd !=-1){
                nums[i] = nums[positiveInd];
                nums[i+1] = nums[negativeInd];
                i++;
            }

        }

        return nums;
    }

    public static int[] rearrangeArrayV2(int[] nums){
        int[] rearrangeArray = new int[nums.length];
        int posInx = -2;
        int negInx = -1;
            for(int i=0;i< nums.length;i++){
                if(nums[i] > 0)
                    rearrangeArray[posInx = posInx + 2] = nums[i];
                else if(nums[i] < 0)
                    rearrangeArray[negInx = negInx + 2] = nums[i];
            }
        return rearrangeArray;
    }

}
