package sortingTechniques;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        bubbleSort(new int[]{41,32,23,17});
    }
    public static void bubbleSort(int[] arr){
        for(int i=0;i< arr.length;i++){
            boolean didSwap = false;
            for(int j=0;j< (arr.length-i-1);j++){
                //swap the adjacent
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    didSwap = true;
                }
            }
            if(!didSwap){
                break;
            }
            System.out.println("run loop");
        }
        Arrays.stream(arr).forEach(System.out::println);
    }

}
