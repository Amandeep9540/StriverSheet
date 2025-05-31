package binarysearch.medium;

public class MedainSortedArray4 {
    public static void main(String[] args) {
        int[] arr1= {1,2};
        int[] arr2 = {3,4};
        System.out.println("-->" + findMedianSortedArraysV3(arr1,arr2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        int[] arr = new int[size];
        int i = 0;int j=0;
        int k = 0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] > nums2[j]){
                arr[k++] = nums2[j++];
            }else{
                arr[k++] = nums1[i++];
            }
        }
//if nums1 have some element
        while(i<nums1.length){
            arr[k++] = nums1[i++];
        }
//if nums2 have some element
        while(j<nums2.length){
            arr[k++] = nums2[j++];
        }

        if(size%2== 0){ //means if odd
            return (arr[size/2] + arr[(size/2)-1])/2.0;
        }else{
            return arr[(size/2) + 1]/2.0;
        }
    }

    public static double findMedianSortedArraysV2(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        int no1 = -1; int no2 = -1;
        int i = 0;int j=0;
        int k = 0;
        while(i<nums1.length && j<nums2.length && k++ <= (size/2)){
            no2 = no1;
            if(nums1[i] > nums2[j]){
                no1 = nums2[j++];
            }else{
                no1 = nums1[i++];
            }
        }
//if nums1 have some element
        while(i<nums1.length &&  k++ <= (size/2)){
            no2 = no1;
            no1 = nums1[i++];
        }
//if nums2 have some element
        while(j<nums2.length  &&  k++ <= (size/2)){
            no2 = no1;
            no1 = nums2[j++];
        }

        if(size % 2 == 0){
            return (no1 + no2)/2.0;
        }
        return no1;
    }

    public static double findMedianSortedArraysV3(int[] arr1, int[] arr2) {
        //always arr1 need to samller
        if(arr1.length > arr2.length)
            return findMedianSortedArraysV3(arr2,arr1);

        int low = 0,high = arr1.length;
        int leftSide = (arr1.length + arr2.length + 1)/2;
        int rightSide = (arr1.length + arr2.length)/2;
        while(high >= low){
            int mid1 = (low + high)/2;
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
                if((arr1.length + arr2.length) % 2 == 0){ // if even length
                    return (Math.max(l1,l2) + Math.min(r1,r2)) / 2.0;
                }
                return Math.max(l1,l2);
            }
        }

        return -1;
    }
}
