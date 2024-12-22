package Arrays.Medium;

public class SortColor75 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,1,2,2,2};
        sortColors(arr);
        for(int i=0;i < arr.length;i++){
            System.out.print(" "+arr[i]);
        }
    }

    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int end = nums.length - 1;

        while(mid <= end){

            if(nums[mid] == 0){
                    // swap with low and move zero by + 1
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;mid++;
            }else if(nums[mid] == 1){
                mid++;
            }else{
                     // swap with high and move - 1
                int temp = nums[mid];
                nums[mid] = nums[end];
                nums[end] = temp;
                end--;
            }

        }
    }
}
