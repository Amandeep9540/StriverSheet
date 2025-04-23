package Arrays.Hard;

import java.util.ArrayList;
import java.util.List;

public class CountInversion_GFG {
    public static void main(String[] args) {
        int[] arr = {5,3,2,4,1};
        System.out.println("-- "+inversionCount(arr));
    }

    static int inversionCount(int[] arr) {
        return countInversionVizmergeSort(arr,0, arr.length-1);
    }

    public static int countInversionVizmergeSort(int[] arr,int start,int end){
        int count = 0;
        if(start >= end){
            return count;
        }
        int mid = (start+end)/2;
        count += countInversionVizmergeSort(arr,start,mid);
        count += countInversionVizmergeSort(arr,mid+1,end);
        count += merge(arr,start,mid,end);
        return count;
    }

    public static int merge(int[]arr,int start,int mid,int end){
        List<Integer> list = new ArrayList<>();
        int left = start;
        int right = mid+1;
        int inversionCount  = 0;
        while(left <= mid && right<=end){
            if(arr[left] < arr[right]){
                list.add(arr[left++]);
            }else{
                inversionCount += (mid - left +1);
                list.add(arr[right++]);
            }
        }

        while(left <= mid){
            list.add(arr[left++]);
        }

        while(right <=end){
            list.add(arr[right++]);
        }

        for(int i= start;i<=end;i++){
            arr[i] = list.get(i-start);
        }
        return  inversionCount;
    }
}
