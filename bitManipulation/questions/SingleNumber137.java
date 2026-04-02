package bitManipulation.questions;

public class SingleNumber137 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,1,0,1,99};
        System.out.println("Single Number == "+singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int singleNo = 0;
        for(int i=0;i<32;i++){
            //check the i = 0 index bit is set or not for every nums index
            int setBits = 0 , unSetBits = 0;
            for(int x : nums){
                //check the i-th bit is set or not
                if((x & (1 << i)) == 0){ // means not set
                    unSetBits++;
                }else { // bit is set
                    setBits++;
                }
            }

            if(setBits % 3 == 1){ // if the bit is not set, then it will not work we want this
                singleNo = singleNo | (1 << i);
            }
        }

        return singleNo;
    }
}
