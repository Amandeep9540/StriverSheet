package Stacks_Queue.implementproblem;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LFUCache460 {
    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        System.out.println(lfu.get(1));      // return 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        System.out.println(lfu.get(2));     // return -1 (not found)
        System.out.println(lfu.get(3));      // return 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        System.out.println(lfu.get(1));;      // return -1 (not found)
        System.out.println(lfu.get(3));;      // return 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        System.out.println(lfu.get(4));;
    }
}

class LFUCache {

    Map<Integer,NodeDLL2> cache;
    Map<Integer,NodeDLL2> counterMap;
    int capacity;

    public LFUCache(int capacity) {
        this.cache = new HashMap<>();
        this.counterMap = new TreeMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            NodeDLL2 existNode = cache.get(key);
            int counter = existNode.counter;
            /* Deleting this node from the counter map*/
            existNode.prev.next = existNode.next;
            existNode.next.prev = existNode.prev;
            /* Remove the counter key if counter contains the only dummy nodes*/
            NodeDLL2 counterNodeHead = counterMap.get(counter);
            if(counterNodeHead.prev == counterNodeHead.next)  //dummy node pointing the dummy node
                counterMap.remove(counter);

            existNode.counter++;
            addNodeAtCounterMap(existNode);
            return existNode.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        int counter = 1;
        /*Remove the node if its exists and use the counter*/
        if(cache.containsKey(key)){
            NodeDLL2 existNode = cache.get(key);
            counter = existNode.counter;
            /* Deleting this node from the counter map*/
            existNode.prev.next = existNode.next;
            existNode.next.prev = existNode.prev;
            /* Remove the counter key if counter contains the only dummy nodes*/
            NodeDLL2 counterNodeHead = counterMap.get(counter);
            if(counterNodeHead.prev == counterNodeHead.next)  //dummy node pointing the dummy node
                counterMap.remove(counter);
            cache.remove(key);
            counter++;
        }
        /*Remove one node because counter and cache size */
        if(cache.size() == capacity){
            Map.Entry<Integer, NodeDLL2> mapEntry = counterMap.entrySet().iterator().next();
            NodeDLL2 removingNode = mapEntry.getValue().prev.prev;
            removingNode.prev.next = removingNode.next;
            removingNode.next.prev = removingNode.prev;
            if(mapEntry.getValue().prev == mapEntry.getValue().next){
                counterMap.remove(mapEntry.getKey());
            }

            cache.remove(removingNode.key);
        }
        /*Create the node and add in counterMap*/
        NodeDLL2 newNode = new NodeDLL2(key,value,counter);
        addNodeAtCounterMap(newNode);
        cache.put(key,newNode);
    }

    private void addNodeAtCounterMap(NodeDLL2 newNode){
        int counter = newNode.counter;
        if(counterMap.containsKey(counter)){
            /* Add the node at the starting*/
            NodeDLL2 nodeHead = counterMap.get(counter);
            newNode.next = nodeHead.next;
            newNode.prev = nodeHead;
            nodeHead.next = newNode;
            newNode.next.prev = newNode;
        }
        else{
            /*Add the node at the counter map with dummy start and end node*/
            NodeDLL2 head = new NodeDLL2(-1,-1,-1);
            NodeDLL2 tail = new NodeDLL2(-1,-1,-1);
            head.next = newNode;
            head.prev = tail;
            newNode.next = tail;
            newNode.prev = head;
            tail.prev = newNode;
            counterMap.put(counter,head);
        }
    }
}


class NodeDLL2{
    NodeDLL2 next;
    NodeDLL2 prev;
    Integer key;
    Integer value;
    Integer counter;

    NodeDLL2(int key,int value,int counter){
        this.key = key;
        this.value = value;
        this.counter = counter;
    }
}