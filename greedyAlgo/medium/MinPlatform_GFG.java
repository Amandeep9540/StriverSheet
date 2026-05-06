package greedyAlgo.medium;

import java.util.*;

public class MinPlatform_GFG {
    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dept = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println("min platform needed -- "+minPlatform(arr,dept));
    }


    public static int minPlatform(int arr[], int dep[]) {
        List<TrainSchu> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            list.add(new TrainSchu(arr[i],'A'));
            list.add(new TrainSchu(dep[i],'D'));
        }

        Collections.sort(list, (a, b) -> {
            if (a.time == b.time) {
                return Character.compare(a.type, b.type);
            }
            return Integer.compare(a.time, b.time);
        });
        int count = 0;
        int maxCount = 0;
        for(int i=0;i<list.size();i++){
            char currTrainType = list.get(i).type;
            if(currTrainType == 'A'){
                count++;
            }else if(currTrainType == 'D'){
                count--;
            }

            maxCount = Math.max(count,maxCount);
        }

        return maxCount;
    }




}

class TrainSchu{
    int time;
    char type; // A-> Arrival, D-> Departure

    TrainSchu(int time, char type){
        this.time = time;
        this.type = type;
    }
}
