package Arrays.Easy;

public class CheckRotateArrayIsSorted1752 {
    public static void main(String[] args) {
        boolean check = check(new int[]{4, 5, 1, 2, 3});
        System.out.println("check" +check);
    }

    public static boolean check(int[] nums) {
        int count = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1] > nums[i]){
                count++;
            }
        }

        return count <= 1 ? true :false;
    }
}
