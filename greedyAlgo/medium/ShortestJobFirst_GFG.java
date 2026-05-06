package greedyAlgo.medium;
import java.util.*;

public class ShortestJobFirst_GFG {
    public static void main(String[] args) {
        int[] bt = {4,3,7,1,2};
        System.out.println(" "+solve(bt));
    }

    static int solve(int bt[]) {
        Arrays.sort(bt);
        int totalWaitingTime = 0; int prevTaskStartedAt = 0;
        for(int i=0;i<bt.length;i++){

            totalWaitingTime += prevTaskStartedAt;

            prevTaskStartedAt += bt[i];
        }

        return totalWaitingTime/bt.length;
    }
}
