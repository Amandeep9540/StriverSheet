package heap.learning;

import java.util.Arrays;
import java.util.List;

public class HeapDemo {
    public static void main(String[] args) {
        Integer[] arr = {90,3,23,1,55,8};
        Heap<Integer> heap = new Heap<>();
        Arrays.stream(arr).forEach(heap::insert);

        System.out.println("Current top ele -- "+heap.top());
        heap.delete();
        System.out.println("Current top ele -- "+heap.top());
        List<Integer> sortedArr = heap.heapSort();

        for (Integer ele : sortedArr){
            System.out.print(ele+" ");
        }
        System.out.println();

        heap.createHeap(List.of(arr));


        sortedArr = heap.heapSort();

        for (Integer ele : sortedArr){
            System.out.print(ele+" ");
        }
    }
}
