package heap.problems.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler621 {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 3;
        System.out.println("-- "+leastInterval(tasks,n));
    }

    public static int leastInterval(char[] tasks, int n) {
                    //Getting the freq of all tasks
            int[] freqArr = new int[26];
            for(int i=0;i<tasks.length;i++){
                freqArr[tasks[i] - 'A']++;
            }
                    //Adding the freq in MaxHeap
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for(int i=0;i<freqArr.length;i++){
                if(freqArr[i] != 0)
                    pq.offer(freqArr[i]);
            }

                    //Pick element with the greater freq and then try to pick n other tasks
            List<Integer> list = new ArrayList<>();
            int j = 0, size = 0 , time = 0;
            while(!pq.isEmpty()){
                list = new ArrayList<>();
                int freq = pq.poll();
                list.add(--freq);
                for(int i=0;i<n;i++){
                    if(!pq.isEmpty()){
                        freq = pq.poll();
                        list.add(--freq);
                    }
                }
                for(int i=0;i<list.size();i++){
                    if(list.get(i) > 0)
                        pq.offer(list.get(i));
                }

                if(pq.isEmpty()){
                    time = time + list.size();
                }else{
                    time = time +  (n + 1);
                }

            }

            return time;
        }


}
