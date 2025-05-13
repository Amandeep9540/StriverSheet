package binarysearch;

public class NumberOfOccurrence_GFG {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        System.out.println("count is -- "+countFreq(arr,2));
    }

    static int countFreq(int[] arr, int target) {
        // code here
        int firstInd = findFirstOccurrence(arr,target);
        int lastInd = findLastOccurrence(arr,target);

        return firstInd >= 0 ? (lastInd - firstInd) + 1 : 0;
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
