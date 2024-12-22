package Arrays.Medium;

import java.util.Arrays;

public class NextPermutation31 {
    public static void main(String[] args) {
        int[] arr = {1,3,2};
        nextPermutation(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void nextPermutation(int[] nums) {
        /*
        * Institution -- (a). find longer prefix match -- nums[i] < nums[i+1]
        *                (b). find greater nums[i] but closest ones.
        *                (c). swap the both index and then sort array after the i index means(sort from i+1 to nums.length)
        * */
    }

}
