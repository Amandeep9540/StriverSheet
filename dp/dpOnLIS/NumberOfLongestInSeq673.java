package dp.dpOnLIS;
import java.util.*;

public class NumberOfLongestInSeq673 {
    public static void main(String[] args) {
        int[] arr ={1,2,4,3,5,4,7,2};
        System.out.println("longest no of seq -- "+findNumberOfLIS(arr));
    }

    public static int findNumberOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        Arrays.fill(lis,1);
        int[] seqCount = new int[nums.length];
        Arrays.fill(seqCount,1);

        for(int i=0;i<lis.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    if(lis[j] + 1 == lis[i]){
                        seqCount[i] += seqCount[j];
                    }else if(lis[j] + 1 > lis[i]){
                        lis[i] = lis[j] + 1;
                        seqCount[i] = seqCount[j];
                    }
                }
            }
        }

        int max = Arrays.stream(lis).max().orElse(0);
        int count = 0;
        for(int i=0;i<lis.length;i++){
            if(lis[i] == max){
                count += seqCount[i];
            }
        }
        return count;

    }
}
