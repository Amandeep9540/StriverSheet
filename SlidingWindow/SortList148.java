package SlidingWindow;

import LinkedList.ListNode;

public class SortList148 {
    public static void main(String[] args) {
        ListNode list = ListNode.constructDLL(new int[]{5, 0, 3, 2, 1});
//        ListNode.traverseList(list);
//        System.out.println("\nthe sorted list is ");
        ListNode sortedList = sortList(list);
        ListNode.traverseList(sortedList);
    }
    public static ListNode sortList(ListNode head) {
        return applyMergeSort(head);
    }

    private static ListNode applyMergeSort(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode middleNode = findMiddleNode(head);

        ListNode rightHead = head;
        ListNode leftHead = middleNode.next;

        middleNode.next = null;
        rightHead = applyMergeSort(rightHead);
        leftHead = applyMergeSort(leftHead);
        return mergeSortedListV2(rightHead,leftHead);
    }


    private static ListNode findMiddleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!= null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static ListNode mergeSortedList(ListNode rightHead, ListNode leftHead) {
        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        while(rightHead != null && leftHead != null){
            ListNode currentNode = new ListNode(-1);
            if(rightHead.val < leftHead.val){
                 currentNode.val = rightHead.val;
                 rightHead = rightHead.next;
            }else{
                 currentNode.val = leftHead.val;
                 leftHead = leftHead.next;
            }
            dummy.next = currentNode;
            dummy = dummy.next;
        }

        while(rightHead != null){
            ListNode currentNode = new ListNode(-1);
            currentNode.val = rightHead.val;
            rightHead = rightHead.next;
            dummy.next = currentNode;
            dummy = dummy.next;
        }

        while(leftHead != null){
            ListNode currentNode = new ListNode(-1);
            currentNode.val = leftHead.val;
            leftHead = leftHead.next;
            dummy.next = currentNode;
            dummy = dummy.next;
        }
        return head.next;
    }


    private static ListNode mergeSortedListV2(ListNode rightHead, ListNode leftHead) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(rightHead != null && leftHead != null) {
            if(rightHead.val < leftHead.val){
                dummy.next = rightHead;
                rightHead = rightHead.next;
            }else{
                dummy.next = leftHead;
                leftHead = leftHead.next;
            }
            dummy = dummy.next;
        }

        if(leftHead != null)
            dummy.next = leftHead;
        if(rightHead != null)
            dummy.next = rightHead;
       return head.next;
    }
}


