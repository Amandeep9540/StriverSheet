package Arrays.Hard;

public class MaximumProductSubarray152 {
    public static void main(String[] args) {
        int[] arr ={2,3,-2,4};
        System.out.println("-- >> -- "+maxProduct(arr));
    }

    public static int maxProduct(int[] nums) {
        int prefixProduct = 1;
        int suffixProduct = 1;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(prefixProduct == 0) prefixProduct = 1;
            if(suffixProduct == 0) suffixProduct = 1;

            prefixProduct *= nums[i];
            suffixProduct *= nums[nums.length - 1 - i];
            max = Math.max(max,Math.max(prefixProduct,suffixProduct));
        }
        return max;
    }
}
