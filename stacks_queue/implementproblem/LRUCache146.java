package stacks_queue.implementproblem;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache146 {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));
    }
}

class LRUCache {
    Map<Integer,NodeDLL> cache = new LinkedHashMap<>();
    int capacity;
    NodeDLL head;
    NodeDLL tail;
    int linkedListSize;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        /*
         * Configure the linked list
         * */
        head = new NodeDLL(-1,-1);
        head.next = new NodeDLL(-1,-1);
        head.next.prev = head;
        tail = head.next;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            NodeDLL node = cache.get(key);
            //remove the head next node
            node.prev.next = node.next;
            node.next.prev = node.prev;
            //add that node at the second last position
            node.next = tail;
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        NodeDLL newNode = new NodeDLL(key, value);
        if(cache.containsKey(key)){
            // Removing the node that exists
            NodeDLL node = cache.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            linkedListSize--;
        }
        //Add the new node at the tail previous
        newNode.next = tail;
        newNode.prev = tail.prev;
        tail.prev.next = newNode;
        tail.prev = newNode;
        cache.put(key,newNode);

        linkedListSize++;
        if(capacity < linkedListSize){
            //Remove the head next node
            cache.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
            linkedListSize--;
        }
    }
}
class NodeDLL{
    NodeDLL next;
    NodeDLL prev;
    Integer key;
    Integer value;

    NodeDLL(int key,int value){
        this.key = key;
        this.value = value;
    }
}