package heap.problems.medium;

import heap.learning.Heap;

import java.util.HashMap;
import java.util.Map;

public class KSortedArr_GFG {
    public static void main(String[] args) {
        int[] arr = {10, 27, 13, 28, 31, 29, 15, 7,30, 19, 47, 49, 25, 2, 20, 43, 44, 35, 12,
        }; int k = 12;
        System.out.println("-- "+isKSortedArray(arr, arr.length, k));
    }

    static String isKSortedArray(int arr[], int n, int k) {
        Map<Integer,Integer> beforeSortingIndexMap = new HashMap<>();
        for(int i=0;i<n;i++){
            beforeSortingIndexMap.put(arr[i],i);
        }
        Heap<Integer> heap = new Heap<>();
        for(int i=0;i<n;i++){
            heap.insert(arr[i]);
            if(i < k ) continue;
            arr[i-k] = heap.delete();
        }
        int i = n - k;
        while(i < arr.length){
            arr[i] = heap.delete();
            i++;
        }

        for(i=0;i<arr.length-1;i++){
            int prevIndex = beforeSortingIndexMap.get(arr[i]);
            if(Math.abs(prevIndex - i) > k ) return "No";
        }

        return "Yes";
    }
}
