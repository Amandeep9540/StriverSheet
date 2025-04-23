package Arrays.Hard;

public class MergeSortedArray88 {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {2,5,6};
        merge(arr1,3,arr2,3);
        for(int ele:arr1){
            System.out.print(" "+ele);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1End = m-1;
        int nums2End = n-1;
        int fillInd = nums1.length-1;
        while(fillInd > nums1End && nums1End >= 0){
            if(nums2[nums2End] >= nums1[nums1End]){
                nums1[fillInd--] = nums2[nums2End--];
            }else{
                nums1[fillInd--] = nums1[nums1End--];
            }
        }

        while(nums2End >= 0){
            nums1[fillInd--] = nums2[nums2End--];
        }
    }
}
