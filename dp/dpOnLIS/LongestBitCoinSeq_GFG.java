package dp.dpOnLIS;
import java.util.*;

public class LongestBitCoinSeq_GFG {
    public static void main(String[] args) {
        int[] arr = {1, 11, 12, 20, 4, 5, 6, 7};
        int len = LongestBitonicSequence(8,arr);
        System.out.println("max len -- "+len);
    }

    public static int LongestBitonicSequence(int n, int[] arr) {
        int[] lisForward = new int[arr.length];
        Arrays.fill(lisForward,1);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[i] > arr[j]){
                    lisForward[i] = Math.max(lisForward[j] + 1,lisForward[i]);
                }
            }
        }
        int[] lisBackward = new int[arr.length];
        Arrays.fill(lisBackward,1);
        for(int i=arr.length-1;i>=0;i--){
            for(int j=i;j<arr.length;j++){
                if(arr[i] > arr[j]){
                    lisBackward[i] = Math.max(lisBackward[j] + 1,lisBackward[i]);
                }
            }
        }

        int result = 0;

        for(int i=0;i<arr.length;i++){
            if(lisForward[i] != 1 && lisBackward[i] != 1)
                result = Math.max(lisForward[i] + lisBackward[i] - 1,result);
        }
        return result;
    }
}
