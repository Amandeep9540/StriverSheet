package sortingTechniques;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {11,12,3,4,51,6,37,8};
        selectionSort(arr);
        Arrays.stream(arr).forEach(System.out::println);

    }
    public static void selectionSort(int[] arr){
        for(int i=0;i< arr.length;i++){
            //find the minimum element
            int minIndex = i;
            for(int j=i;j< arr.length;j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            //swap the value
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

        }
    }
}
