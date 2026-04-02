package bitManipulation.questions;

public class SingleNumber260 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        int[] singles = singleNumber(nums);
        System.out.println(singles[0]+" "+singles[1]);
    }

    public static int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int x : nums)
            xor = xor ^ x;

        int mask = getMask(xor,nums);

        int group1 = 0;
        int group2 = 0;

        for(int x : nums){
            if((x & mask) == 0){
                group1 = group1 ^ x;
            }else{
                group2 = group2 ^ x;
            }
        }


        return new int[]{group1,group2};
    }

    public static int getMask(int xor,int[] nums){
        //checking which place bit is set

        // int place = -1;
        // for(int i=0;i<31;i++){
        //     if((xor & (1 << i)) != 0){
        //         place = i; break;
        //     }
        // }

        // return 1 << place;


        //or we can do this
        return xor & (-xor);
    }
}
