package LinkedList.MediumProbLL;

import LinkedList.ListNode;

public class LinkedListCycle141 {
    public static void main(String[] args) {
        System.out.println("has cycle :: "+hasCycle(ListNode.getDummyData()));
    }
    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
