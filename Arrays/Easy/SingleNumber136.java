package Arrays.Easy;

public class SingleNumber136 {
    public static void main(String[] args) {
        System.out.println("singleNumber :: "+singleNumber(new int[]{2,2,1}));
    }

    public static int singleNumber(int[] nums) {
        int ans = 0;
        for(Integer value:nums){
            ans = ans ^ value;
        }
        return ans;
    }
}
