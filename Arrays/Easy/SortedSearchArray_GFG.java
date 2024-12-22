package Arrays.Easy;

public class SortedSearchArray_GFG {
    public static void main(String[] args) {
        System.out.println("is ele found :: "+searchInSorted(new int[]{1, 2,2,2, 6}, 2));
    }

    static boolean searchInSorted(int arr[], int k) {
        // we can apply binary search here
        return applyBinarySearch(arr,k,0,arr.length-1)== -1 ? false :true;
    }

    private static int applyBinarySearch(int[] arr, int k,int low, int high) {
        if(low>high)
            return -1;

        int mid = (low + high)/2;

        if(arr[mid] == k)
            return mid;
        else if(arr[mid] < k)
            return applyBinarySearch(arr,k,mid+1,high);
        else
            return applyBinarySearch(arr,k,0,mid-1);

    }
}
