package binarysearch;

public class FirstAndLastOccurence34 {
    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int[] searchRangeArr = searchRange(arr, 8);
        System.out.println("first ind "+searchRangeArr[0]);
        System.out.println("last ind "+searchRangeArr[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int firstInd = findFirstOccurrence(nums,target);
        int lastInd = findLastOccurrence(nums,target);

        return new int[]{firstInd, lastInd};
    }

    public static int findFirstOccurrence(int[] arr,int tar){
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] >= tar){
                if(arr[mid] == tar)
                    ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return ans;
    }

    public static int findLastOccurrence(int[] arr,int tar){
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] <= tar){
                if(arr[mid] == tar)
                    ans = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return ans;
    }
}
