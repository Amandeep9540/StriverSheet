package linkedlist.HardProbLL;

import linkedlist.ListNode;

import java.util.List;

public class MergeKSortedList23 {
    public static void main(String[] args) {
        ListNode list1 = ListNode.constructDLL(new int[]{1,4,5});
        ListNode list2 = ListNode.constructDLL(new int[]{1,3,4});
        ListNode list3 = ListNode.constructDLL(new int[]{2,6});
        ListNode[] lists = {list1,list2,list3};
        ListNode sortedList = mergeKLists(lists);
        ListNode.traverseList(sortedList);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        return partitionAndMerge(0,lists.length - 1, lists);
    }

    private static ListNode partitionAndMerge(int start, int end , ListNode[] lists){
        if(start > end) return null;
        if(start == end) return lists[start];

        int mid = (start + end) / 2;

        ListNode l1 = partitionAndMerge(start, mid, lists);
        ListNode l2 = partitionAndMerge(mid + 1, end, lists);

        return mergeTwoList(l1,l2);
    }

    private static ListNode mergeTwoList(ListNode node1, ListNode node2){
        if( node1 == null ) return node2;
        if( node2 == null ) return node1;

        if(node1.val >= node2.val){
            node2.next = mergeTwoList(node1,node2.next);
            return node2;
        }else{
            node1.next = mergeTwoList(node1.next,node2);
            return node1;
        }
    }
}
