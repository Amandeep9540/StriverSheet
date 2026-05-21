package heap.learning;

import java.util.ArrayList;
import java.util.List;

public class Heap<T extends Comparable<T>> {

    ArrayList<T> list = new ArrayList<>();

    /**
     * This method will insert the element into the list. T.C - O(log N)
     * */
    public void insert(T t){
        if(list.isEmpty()){
            list.add(t); return;
        }
            //Add the element at the last of list and then perform the heapify operation
        list.add(t);
        upHeap(list.size()-1);
    }


    /**
     * This method will delete the element into the list. T.C - O(log N)
     * */
    public T delete(){
            if(list.isEmpty())
                throw new RuntimeException("Heap is Empty");

            T first = list.getFirst();
            T lastEle = list.removeLast();
            if(!list.isEmpty()) {
                list.set(0, lastEle);
                downheap(0);
            }
        return first;
    }


    public T top(){
        return list.isEmpty() ? null : list.getFirst();
    }

    /**
     * This method will remove the all element from the heap and insert that in a list in sorted manner. T.C O(n log n )
     * */
    public List<T> heapSort(){
        List<T> heapSortList = new ArrayList<>();
        while(!list.isEmpty()){
            T ele = delete();
            heapSortList.add(ele);
        }
        return heapSortList;
    }


    /**
    * In the heapify method , we compare the last element with its parent
    * */
    private void upHeap(int index) {
        if(index == 0) return;
        int p = parent(index);
        if(p >= 0 && list.get(p).compareTo(list.get(index)) >= 0){
            swap(index,p);
            upHeap(p);
        }
    }

    private void downheap(int index) {
        int min = index;
        int left = left(min);
        int right = right(min);

            //Picking greater element of both side in comparison of index
        if(left < list.size() && list.get(min).compareTo(list.get(left)) > 0){
            min = left;
        }
        if(right < list.size() && list.get(min).compareTo(list.get(right)) > 0){
            min = right;
        }
        if(min != index){
            swap(min,index);
            downheap(min);
        }
    }

    public  void createHeap(List<T> list){
        // copy elements
        this.list = new ArrayList<>(list);

        int n = list.size();

            // start from last non-leaf node, in complete binary tree leaf starts from n/2
        for(int i = n/2 - 1; i >= 0; i--) {
            downheap(i);
        }
    }

    public void swap(int first, int second){
        T temp = list.get(first);
        list.set(first,list.get(second));
        list.set(second,temp);
    }

    public int parent(int i){
        return (i - 1) / 2;
    }

    public int left(int i){
        return 2*i + 1;
    }

    public int right(int i){
        return 2*i + 2;
    }
    public int size(){
        return list.size();
    }
}
