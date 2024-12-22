package Arrays.Easy;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RotateArray189 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
//        System.out.println(arr.length%3);
        rotateV3(arr,10);
        Arrays.stream(arr).forEach(System.out::println);
    }

    /*
    *   This question has 3 different solutions::
    * */


    /*
    * Time Complexity :: O(2n), Space Complexity :: O(n)
    * */
    public static void rotateV1(int[] nums, int k) {
        int[] ansArr = new int[nums.length];

        for(int i=0;i< nums.length;i++){
            ansArr[(i+k) % (nums.length)] = nums[i];
        }

        for(int i=0;i< nums.length;i++){
            nums[i] = ansArr[i];
        }
    }

    /*
    * Time Complexity :: O(2n) , Space Complexity :: O(k)
    * */
    public static void rotateV2(int[] nums, int k){
        k = k % nums.length;

        if(k== 0 || k== nums.length)
            return;

        int[] rotatedHalf  = new int[k];
        int tempK = k;

        for(int i=0;i< rotatedHalf.length;i++){
            rotatedHalf[i] = nums[nums.length-tempK];
            tempK--;
        }

            int lastIndex = nums.length - 1;
        for(int i= (nums.length - k -1);i>=0;i--){
                nums[lastIndex--] = nums[i];
        }


        for(int i=0;i< rotatedHalf.length;i++){
            nums[i] = rotatedHalf[i];
        }

    }

    /*
     * Time Complexity :: O(2n) , Space Complexity :: O(1)
     * */
    public static void rotateV3(int[] nums,int k){
        k = k % nums.length;
        if(k== 0 || k== nums.length)
            return;

        reverseArray(nums,0, nums.length-1-k);
        reverseArray(nums,nums.length-k, nums.length-1);
        reverseArray(nums,0, nums.length-1);

    }

    public static void reverseArray(int[] arr, int startIn, int endIn){
          while(startIn < endIn){
              int temp = arr[startIn];
              arr[startIn] = arr[endIn];
              arr[endIn] = temp;
              startIn++;endIn--;
          }
    }
}












