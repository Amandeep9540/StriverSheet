package heap.problems.hard;
import java.util.*;

public class MedianFromStream295 {
    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(" 1. -- "+finder.findMedian());
        finder.addNum(3);
        System.out.println(" 2. -- "+finder.findMedian());
    }
}

class MedianFinder {
    PriorityQueue<Integer> leftMaxHeap;
    PriorityQueue<Integer> rightMinHeap;
    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        rightMinHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        //1. Insert in the Heap
        if(leftMaxHeap.isEmpty() || leftMaxHeap.peek() > num){
            leftMaxHeap.offer(num);
        }else{
            rightMinHeap.offer(num);
        }

        //2. maintaine the size of heap
        if(leftMaxHeap.size() > rightMinHeap.size() + 1){
            rightMinHeap.offer(leftMaxHeap.poll());
        }else if(rightMinHeap.size() > leftMaxHeap.size()){
            leftMaxHeap.offer(rightMinHeap.poll());
        }
    }

    public double findMedian() {
        //if both heap size if equal means stream size is even
        if(leftMaxHeap.size() == rightMinHeap.size()){
            return (leftMaxHeap.peek() + rightMinHeap.peek())/2.0d;
        }

        return leftMaxHeap.peek();
    }
}
