package Arrays.Hard;

import java.util.ArrayList;
import java.util.List;

public class ReversePair493 {
    public static void main(String[] args) {
        int[] arr = {1,3,2,3,1};
        System.out.println("count will be -- "+ reversePairs(arr));
    }

    public static int reversePairs(int[] nums) {
        return findReversePair(nums,0,nums.length-1);
    }
    public static int findReversePair(int[] nums,int start,int end){
        int count = 0;
        if(start>=end) return count;
        int mid = (start+end)/2;
        count += findReversePair(nums,start,mid);
        count += findReversePair(nums,mid+1,end);
        count += countPairs(nums,start,mid,end);
        mergerArray(nums,start,mid,end);
        return count;
    }

    public static void mergerArray(int[] arr,int start,int mid,int end){
        List<Integer> list = new ArrayList<>();
        int left = start;
        int right = mid+1;
        while(left <= mid && right<=end){
            if(arr[left] <= arr[right]){
                list.add(arr[left++]);
            }else{
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
    }

    public static int countPairs(int[] arr,int start,int mid,int end){
        int count = 0;
        int right = start;
        int left = mid+1;

        while(right <= mid && left <= end){
            if(arr[right] > (long)2*arr[left]){
                count += (mid - right) + 1;
                left++;
            }else{
                right++;
            }
        }

        return count;
    }
}
