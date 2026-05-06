package greedyAlgo.medium;
import java.util.*;

public class NonOverlappingIntervals435 {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(" -- "+eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
                //sort
        Arrays.sort(intervals,(a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        int lastEndInterval = intervals[0][1];
        int count = 0;
        for(int i=1;i<intervals.length;i++){
            if(lastEndInterval > intervals[i][0]){
                count++;
                lastEndInterval = Math.min(lastEndInterval,intervals[i][1]);
            }else{
                lastEndInterval = intervals[i][1];
            }
        }
        return count;
    }

    public static int eraseOverlapIntervalsV2(int[][] intervals) {
        //sort
        Arrays.sort(intervals,(a,b)->{return Integer.compare(a[1],b[1]);
        });
        int lastEndTime = intervals[0][1];
        int count = 1;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] >= lastEndTime){
                count++; lastEndTime = intervals[i][1];
            }
        }

        return intervals.length - count;
    }
}
