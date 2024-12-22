package Arrays.Medium;

public class MajorityEle169 {
    public static void main(String[] args) {
        int majorityElement = majorityElement(new int[]{2,2,1,1,1,2,2});
        System.out.println("majorityElement --- "+majorityElement);
    }

    public static int majorityElement(int[] nums) {
        int majorityEle = nums[0];
        int count = 1;

        for(int i=1;i<nums.length;i++){

            if(count == 0){
                majorityEle = nums[i];
            }

            if(majorityEle == nums[i]){
                count++;
            }else{
                count--;
            }

        }

        return majorityEle;
    }
}
