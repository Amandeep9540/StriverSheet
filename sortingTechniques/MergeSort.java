package sortingTechniques;

import java.util.ArrayList;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = { 9, 4, 7, 6, 3, 1, 5 };
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void mergeSort(int[] arr){
        applymergeSort( arr,0,arr.length-1);
    }

    public static void applymergeSort(int[] arr,int low,int high){
        if (low >= high) return;
        int mid = (low +high)/2;
        applymergeSort(arr,low,mid);
        applymergeSort(arr,mid+1,high);
        mergeArray(arr,low,mid,high);
    }

    private static void mergeArray(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        while(left <= mid){
            temp.add(arr[left]);
            left++;
        }
        while(right <= high){
            temp.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
}
