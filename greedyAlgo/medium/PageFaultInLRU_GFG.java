package greedyAlgo.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PageFaultInLRU_GFG {
    public static void main(String[] args) {
        int C = 4;
        int[] pages = {3, 1, 0, 2, 5, 4, 1, 2};
        System.out.println("fault pages -- " + pageFaults(pages.length, C, pages));
    }


    static int pageFaultsV1(int N, int C, int pages[]) {
        int faultCount = 0;
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(C, 0.75f, true); //accessOrder-true == Whenever we get() or put(), the key moves to most recently used (MRU) position
        for (int i = 0; i < pages.length; i++) {
            int page = pages[i];
            if (!map.containsKey(page)) {
                faultCount++;
                if (map.size() == C) {
                    int lru = map.keySet().iterator().next(); // least recently used
                    map.remove(lru);
                }
            }
            map.put(page, 1);
        }

        return faultCount;
    }


    public static Node head = null;
    public static Node last = null;
    public static int listSize = 0;
    public static int capacity = 0;
    public static Map<Integer, Node> map = new HashMap<>();

    static int pageFaults(int N, int C, int pages[]) {
        int faultCount = 0;
        capacity = C;
        for (int i = 0; i < pages.length; i++) {
            int page = pages[i];
            if (map.containsKey(page)) {
                //remove that element and add at the last
                Node node = map.get(page);
                remove(node);
                map.remove(page);
            } else faultCount++;
            // add the node in linked list and map
            Node node = addLast(page); // it first check the capacity if capacity is less then remove the first and then add at last
            map.put(page, node);
        }


        return faultCount;
    }


    public static void remove(Node node) {
        if (head == node) {
            head = node.next;
        } else if (last == node) {
            last.prev.next = null;
            last = last.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        listSize--;
        map.remove(node.value);
    }

    public static Node addLast(int value) {
        if (listSize == capacity) {
            remove(head);
        }
        if (listSize == 0) {
            Node node = new Node(value, null, null);
            head = node;
            last = node;
            listSize++;
            return node;
        }
        Node node = new Node(value, last, null);
        last.next = node;
        last = node;
        listSize++;
        return node;
    }

}


class Node{
    int value;
    Node prev;
    Node next;

    public Node(int value, Node prev, Node next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}
