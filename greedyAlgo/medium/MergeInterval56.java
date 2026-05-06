package greedyAlgo.medium;

import java.util.*;

public class MergeInterval56 {
    public static void main(String[] args) {
        int[][] intervals = {{1,6},{6,7},{8,19},{12,16},{3,4},};
        int[][] result = merge(intervals);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }


    public static int[][] merge(int[][] intervals) {
        //sort the array
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        List<int[]> result = new ArrayList<>();

        for(int i=0;i<intervals.length;i++){
            int resultSize = result.size();
            if(resultSize == 0 ){
                result.add(new int[]{intervals[i][0],intervals[i][1]});
                continue;
            }
            int[] res = result.get(resultSize-1);
            if(resultSize == 0 || res[1] < intervals[i][0]){
                result.add(new int[]{intervals[i][0],intervals[i][1]});
            }else{
                res[0] = Math.min(res[0],intervals[i][0]);
                res[1] = Math.max(res[1],intervals[i][1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
