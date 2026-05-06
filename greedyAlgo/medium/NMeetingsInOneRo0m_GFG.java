package greedyAlgo.medium;

import java.util.*;

public class NMeetingsInOneRo0m_GFG {
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        System.out.println("max meets -- "+maxMeetings(start,end));
    }

    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public static int maxMeetings(int start[], int end[]) {
        List<MeetingsData> meetDataList = new ArrayList<>();
        for(int i=0;i<start.length;i++){
            meetDataList.add(new MeetingsData(start[i],end[i],i));
        }

        Collections.sort(meetDataList,(a, b)-> Integer.compare(a.end,b.end));

        int meets = 0;
        int busyTill = -1;

        for(MeetingsData md : meetDataList){
            if(md.start > busyTill){
                meets++;
                busyTill = md.end;
            }
        }

        return meets;

    }

    static class MeetingsData{
        int start;
        int end;
        int pos; //this will help if ques is asked to return the meeting order
        public MeetingsData(int start,int end,int pos){
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }
}
