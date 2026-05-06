package greedyAlgo.medium;

import java.util.*;

public class MergeInterval57 {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,4},{6,7},{8,10},{12,16}};
        int[] newIntervals = {5,8};
        int[][] result = insert(intervals,newIntervals);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }

    public static int[][] insert(int[][] intervals, int[] newIntervals) {
        List<int[]> result = new ArrayList<>();

        int i = 0;
        //adding the first half
        for(i=0;i<intervals.length;i++){
            if(intervals[i][1] >= newIntervals[0]){
                break;
            }else{
                result.add(intervals[i]);
            }
        }

        //adding the overlapping half
        while(i<intervals.length && newIntervals[1] >= intervals[i][0]){
            newIntervals[0] = Math.min(intervals[i][0],newIntervals[0]);
            newIntervals[1] = Math.max(intervals[i][1],newIntervals[1]);
            i++;
        }
        result.add(newIntervals);
        //adding the remaining part

        while(i<intervals.length){
            result.add(intervals[i]);
            i++;
        }


        return result.toArray(new int[result.size()][]);
    }
}
