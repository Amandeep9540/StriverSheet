package LinkedList.MediumProbLL;

import LinkedList.ListNode;

public class OddEvenLL328 {
    public static void main(String[] args) {
        ListNode head = ListNode.constructDLL(new int[]{1, 2, 3, 4, 5});
        System.out.println("original linked list ");
        ListNode.traverseList(head);
        System.out.println("\nsegregated list ");
        ListNode.traverseList(oddEvenList(head));
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode evenNode = head.next;
        ListNode oddNode = head;
        ListNode evenFirst  = head.next;

        ListNode temp = head.next.next;
        while(temp != null){
            oddNode.next = temp;
            evenNode.next = temp.next;

            oddNode = oddNode.next;
            evenNode = evenNode.next;
            temp = temp == null || temp.next == null ? null : temp.next.next;
        }
        oddNode.next = evenFirst;
       return head;
    }
}
