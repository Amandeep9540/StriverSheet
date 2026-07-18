package segmentTree.ques.hard;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarIII732 {
    public static void main(String[] args) {
        MyCalendarThree ques = new MyCalendarThree();
        System.out.println("count -- "+ques.book(10,20));
        System.out.println("count -- "+ques.book(10,30));
        System.out.println("count -- "+ques.book(40,90));
    }

    TreeMap<Integer,Integer> eventTimeMap = new TreeMap<>();
    int maxBookings = 0;

    /** TC - O(n +  log n) */
    public int book(int startTime, int endTime) {
        eventTimeMap.put(startTime, eventTimeMap.getOrDefault(startTime,0)+1); //O(log n)
        eventTimeMap.put(endTime, eventTimeMap.getOrDefault(endTime,0) -1); //O(log n)
        int currMaxBooking = 0;
        int bookings = 0;
        for(Map.Entry<Integer,Integer> entry : eventTimeMap.entrySet()){ //O( n)
            bookings += entry.getValue();
            currMaxBooking = Math.max(bookings, currMaxBooking);
        }
        maxBookings = Math.max(currMaxBooking,maxBookings);
        return maxBookings;
    }


}

class MyCalendarThree {

    SegmentTree root;
    public MyCalendarThree() {
        root = new SegmentTree(0, (int)1e9);
    }


    public int book(int startTime, int endTime) {
        update(root,startTime,endTime-1);
        return root.max;
    }

    public void update(SegmentTree node, int left, int right){
        if(node == null || left > node.end  || right < node.start) return;
        if(left <= node.start && node.end <= right){
            node.bookingCount++; node.max++; //max is related to this range only, showing this range max
            return;
        }
        pushOrCreateChilds(node);
        update(node.left, left, right);
        update(node.right, left, right);
        node.max = node.bookingCount + Math.max(node.left.max , node.right.max);
    }

    private void pushOrCreateChilds(SegmentTree node){
        if(node.start == node.end) return; // its a leaf node

        int mid = node.start + (node.end - node.start) / 2;
        if(node.left == null)
            node.left = new SegmentTree(node.start,mid);
        if(node.right == null)
            node.right = new SegmentTree(mid + 1,node.end);
    }


}

class SegmentTree{
    int start;
    int end;
    SegmentTree left;
    SegmentTree right;
    int max;
    int bookingCount;
    SegmentTree(int s, int e) {
        start = s;
        end = e;
    }
}
