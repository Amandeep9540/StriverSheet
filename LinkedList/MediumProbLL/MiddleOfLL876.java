package LinkedList.MediumProbLL;

import LinkedList.ListNode;

public class MiddleOfLL876 {
    public static void main(String[] args) {
        System.out.println("middle Node value is :: {} "+middleNode(ListNode.getDummyData()));
    }

    public static ListNode middleNode(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
            while(fast != null || fast.next != null){
                 fast = fast.next.next;
                 slow = slow.next;
            }
        return slow;
    }
}
