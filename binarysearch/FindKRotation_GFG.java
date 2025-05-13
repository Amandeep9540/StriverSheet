package binarysearch;

import java.util.Arrays;
import java.util.List;

public class FindKRotation_GFG {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(9, 11, 2, 3, 5, 7);
        System.out.println("Rotated by -- "+findKRotation(list));
    }

    public static int findKRotation(List<Integer> arr) {
        int start = 0;
        int end = arr.size() - 1;
        int minInd = 0;
        while(end >= start){
            int mid = start + (end - start)/2;

            if(arr.get(start) <= arr.get(mid)){ // first half is sorted
                if(arr.get(minInd) > arr.get(start))
                    minInd = start;
                start = mid + 1;
            }else{ // second half is sorted
                if(arr.get(minInd) > arr.get(mid))
                    minInd = mid;
                end = mid - 1;
            }
        }

        return minInd;
    }
}
