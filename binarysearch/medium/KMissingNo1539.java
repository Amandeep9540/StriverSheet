package binarysearch.medium;

public class KMissingNo1539 {
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        System.out.println("missing no is -- "+findKthPositive(arr,5));
    }

    /*
    * Time Complexity -- O(n)
    * */
    public static int findKthPositive(int[] arr, int k) {
        if(arr[0] > k ) return k;
        for(int ele : arr){
            if(ele > k)
                return k;
            else
                k++;
        }
        return k;
    }

    /*
     * Time Complexity -- O(log(n))
     * */
    public static int findKthPositiveV2(int[] arr, int k) {
        if(arr[0] > k ) return k; //check if missing no present before starting actuall array
        if(arr[arr.length-1] - (arr.length) == 0 ) return arr[arr.length-1] + k; // check if the array is simple counting or no missing no
        int low = 0;
        int high = arr.length - 1;

        while(high >= low){
            int mid = (low + high)/2;

            if((arr[mid] - (mid +1)) < k )
                low = mid + 1;
            else
                high = mid - 1;
        }

        return (arr[high]) + (k-(arr[high] - high)) + 1;
    }
}
