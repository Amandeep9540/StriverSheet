package greedyAlgo.medium;

import java.util.*;

public class JobSequencing_GFG {
    public static void main(String[] args) {
        int[] deadline = {2, 1, 2, 1, 1};
        int[] profit = {100, 19, 27, 25, 15};
        jobSequencing(deadline,profit);
    }


    /**
     * This solution is giving the TLE , T.C - O(n²),
     * We can optimize this by using DS that gives us the next free day where we can perform the job , DSU .......
     * */
    public static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        List<JobData> jobDatalist = new ArrayList<>();
        for(int i=0;i<deadline.length;i++){
            jobDatalist.add(new JobData(deadline[i],profit[i]));
        }

        Collections.sort(jobDatalist,(a,b)->{
            if(a.profit == b.profit)
                return Integer.compare(b.deadline,a.deadline);
            return Integer.compare(b.profit,a.profit);
        });

        boolean[] isJobPerformed = new boolean[deadline.length+1]; // Constraints - 1 ≤ deadline[i] ≤ deadline.size()
        int count = 0 , totalProfit = 0;
        for(JobData jd : jobDatalist){
            while(jd.deadline > 0 && isJobPerformed[jd.deadline]){
                jd.deadline--;
            }

            if(jd.deadline > 0 && !isJobPerformed[jd.deadline]){ //
                count++;
                totalProfit += jd.profit;
                isJobPerformed[jd.deadline] = true; // job performed
            }
        }

        return new ArrayList<>(Arrays.asList(count, totalProfit));
    }


    /**
     * This solution uses the DSU to find the next available slot by DSU.
     * DSU parent is always the min that job is not schedule that day (that why we merge the available slot with -1).
     * if the parent is 0 then we can't do this job.
     * */
    public ArrayList<Integer> jobSequencingV2(int[] deadline, int[] profit) {
        // code here
        List<JobData> jobDatalist = new ArrayList<>();
        int maxDeadline = 0;
        for(int i=0;i<deadline.length;i++){
            maxDeadline = Math.max(maxDeadline,deadline[i]);
            jobDatalist.add(new JobData(deadline[i],profit[i]));
        }

        Collections.sort(jobDatalist,(a,b)->{
            if(a.profit == b.profit)
                return Integer.compare(b.deadline,a.deadline);
            return Integer.compare(b.profit,a.profit);
        });

        int[] parent = initilizeParent(maxDeadline + 1);

        int count = 0 , totalProfit = 0;
        for(JobData jd : jobDatalist){
            int avaiableSlot = find(jd.deadline,parent);
            if(avaiableSlot > 0){
                count++;
                totalProfit += jd.profit;
                merge(avaiableSlot,avaiableSlot-1,parent);
            }
        }

        return new ArrayList<>(Arrays.asList(count, totalProfit));
    }

    public static void merge(int x,int y,int[] parent){
        int x_parent = find(x,parent);
        int y_parent = find(y,parent);
        if(x_parent == y_parent) return;
        parent[x_parent] = y_parent;
    }

    public static int[] initilizeParent(int n){
        int[] parent = new int[n];
        for(int i=0;i<n;i++)
            parent[i] = i;
        return parent;
    }

    public static int find(int x, int[] parent){
        if(x == parent[x]) return x;
        int x_parent = find(parent[x],parent);
        parent[x] = x_parent;
        return x_parent;
    }
}

class JobData{
    int deadline;
    int profit;
    JobData(int deadline,int profit){
        this.deadline = deadline;
        this.profit = profit;
    }
}
