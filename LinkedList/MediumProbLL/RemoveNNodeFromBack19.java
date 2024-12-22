package LinkedList.MediumProbLL;

import LinkedList.ListNode;

public class RemoveNNodeFromBack19 {
    public static void main(String[] args) {
        ListNode head = ListNode.constructDLL(new int[]{1, 2, 3, 4, 5, 6});
        ListNode modifiedHead = removeNthFromEnd(head, 4);
        ListNode.traverseList(modifiedHead);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        ListNode prev = head;

            //Take n steps
        while(n>0){
            temp = temp.next;
            n--;
        }
                //if taking n steps reach to null the length and n is same
        if(temp == null){
            return head.next;
        }

            //Take L-n steps
        while(temp != null && temp.next != null){
            prev = prev.next;
            temp = temp.next;
        }


        prev.next = prev.next.next;
        return head;
    }
}
