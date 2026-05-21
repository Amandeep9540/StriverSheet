package heap.problems.medium;

import linkedlist.ListNode;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class MergeKSortedList23 {
    public static void main(String[] args) {
        linkedlist.ListNode list1 = linkedlist.ListNode.constructDLL(new int[]{1,4,5});
        linkedlist.ListNode list2 = linkedlist.ListNode.constructDLL(new int[]{1,3,4});
        linkedlist.ListNode list3 = linkedlist.ListNode.constructDLL(new int[]{2,6});
        linkedlist.ListNode[] lists = {list1,list2,list3};
        linkedlist.ListNode sortedList = mergeKLists(lists);
        linkedlist.ListNode.traverseList(sortedList);
    }


    /**
     * Time Complexity - O(NlogK) and Space Complexity - O(K)
     * */
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pQueue = new PriorityQueue<>((a, b)->Integer.compare(a.val,b.val));
        //adding the all heap to pQueue
        for(int i=0;i<lists.length;i++){
            ListNode node = lists[i];
            if(node != null)
                pQueue.add(lists[i]);
        }

        ListNode tempResultHead = new ListNode(-1,null);
        ListNode temp = tempResultHead;
        //Performing the operation :: we delete the top of pQueue and then add that node next element
        while(!pQueue.isEmpty()){
            ListNode node = pQueue.poll();
            if(node.next != null)
                pQueue.add(node.next);
            node.next = null;
            temp.next = node;
            temp = temp.next;
        }
        return tempResultHead.next;
    }



}
