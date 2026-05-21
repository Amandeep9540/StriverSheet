package greedyAlgo.medium;
import java.util.*;

public class TaskScheduler621 {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 3;
        System.out.println("-- "+leastInterval(tasks,n));
    }

    /**
     * The idea is get the freq of every ele and sort that if A-4,B-4,C-4,D-1 and n = 2
     * A__A__A__A we have idle spot = 6 and empty spaces is 3.
     *
     * We are focusing to fill this idleSpot and if we can -> we will return the tasks.length
     *                                            we can't -> we will return tasks.length + idleSpot
     * */
    public static int leastInterval(char[] tasks, int n) {
        int[] freqArr = new int[26];
        for(int i=0;i<tasks.length;i++){
            freqArr[tasks[i] - 'A']++;
        }

        Arrays.sort(freqArr);
        int maxFreq = freqArr[25];
        int emptyChunks = maxFreq - 1;
        int idleSpot = emptyChunks * n;

        for(int i=24;i>=0;i--){
            idleSpot -= Math.min(emptyChunks,freqArr[i]);
            if(idleSpot <= 0 ){
                return tasks.length;
            }
        }

        return idleSpot + tasks.length;
    }
}
