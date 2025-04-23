package Arrays.Hard;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals56 {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = merge(intervals);
        for(int i=0;i<merge.length;i++){
            System.out.println(merge[i][0] + "  --  "+merge[i][1]);
        }
    }

    public static int[][] merge(int[][] intervals) {
        java.util.Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();

        int start = 0;
        while (start < intervals.length) {
            int currentStart = intervals[start][0];
            int currentEnd = intervals[start][1];
            int i = start + 1;

            while (i < intervals.length && intervals[i][0] <= currentEnd) {
                currentEnd = Math.max(currentEnd, intervals[i][1]);
                i++;
            }

            merged.add(new int[]{currentStart, currentEnd});
            start = i;
        }
        return merged.toArray(new int[merged.size()][]);

    }
}
