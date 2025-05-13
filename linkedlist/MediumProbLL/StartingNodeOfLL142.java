package linkedlist.MediumProbLL;

import linkedlist.ListNode;

public class StartingNodeOfLL142 {
    public static void main(String[] args) {

    }

    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        ListNode mettingPoint = hasCycle(head);
        if(mettingPoint == null)
            return null;
        while(head != mettingPoint){
            head = head.next;
            mettingPoint = mettingPoint.next;
        }
        return mettingPoint;
    }

    public static ListNode  hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return slow;
            }
        }
        return null;
    }
}
