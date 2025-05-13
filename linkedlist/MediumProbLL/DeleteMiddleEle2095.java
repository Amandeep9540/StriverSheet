package linkedlist.MediumProbLL;

import linkedlist.ListNode;

public class DeleteMiddleEle2095 {
    public static void main(String[] args) {

    }
    public ListNode deleteMiddle(ListNode head) {
        if(head == null ){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode slowPrev = null;

        while(fast != null || fast.next != null){
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        slowPrev.next = slowPrev.next.next;
        return head;
    }
}
