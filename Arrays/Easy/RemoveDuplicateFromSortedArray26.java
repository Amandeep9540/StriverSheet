package Arrays.Easy;

public class RemoveDuplicateFromSortedArray26 {
    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,1,1,2,2,3,3,4};
        int i = removeDuplicates(arr);
        System.out.println(i);
        System.out.println("-------------------------------");
        for(int j=0;j<=i;j++){
            System.out.println(arr[j]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1)
            return nums.length;

        int uniqueIndex = 0;

        for(int currentIndex = 1;currentIndex< nums.length ;currentIndex++){
            if(nums[uniqueIndex] != nums[currentIndex]){
                nums[++uniqueIndex] = nums[currentIndex];
            }
        }

        return ++uniqueIndex;
    }
}
