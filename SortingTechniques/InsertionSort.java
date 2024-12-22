package SortingTechniques;

public class InsertionSort {
    public static void main(String[] args) {
        insertionSort(new int[]{9,14,15,12,6,8,13});
    }
    public static void insertionSort(int[] arr){
            //sort the arr
        for(int i=1;i< arr.length;i++){
            for(int j=i;j>0;j--){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }else {
                    break;
                }

            }
        }

            //print the arr
        for(int i=0;i< arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
