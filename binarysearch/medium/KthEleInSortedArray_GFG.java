package binarysearch.medium;

public class KthEleInSortedArray_GFG {
    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7, 9};
        int[] b = {1, 4, 8, 10};
        System.out.println("kth element --> "+kthElement(a,b,5));
    }

    public static int kthElement(int arr1[], int arr2[], int k) {

        if(arr1.length > arr2.length)
            return kthElement(arr2,arr1,k);


        int leftSide = k;
        int low = Math.max(0,k-arr2.length), high = Math.min(arr1.length,k);

        while(high >= low){
            int mid1 = low + (high-low)/2;
            int mid2 = leftSide - mid1;

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if(mid1 > 0)
                l1= arr1[mid1-1];
            if(mid2 > 0)
                l2= arr2[mid2-1];
            if(mid1 < arr1.length)
                r1= arr1[mid1];
            if(mid2 < arr2.length)
                r2= arr2[mid2];

            if(l1 > r2)
                high = mid1 - 1;
            else if(l2 > r1)
                low = mid1 + 1;
            else{
                return Math.max(l1,l2);
            }
        }

        return -1;
    }
}
