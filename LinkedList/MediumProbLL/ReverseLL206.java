package LinkedList.MediumProbLL;

import LinkedList.ListNode;

public class ReverseLL206 {
    public static void main(String[] args) {
        ListNode head = ListNode.getDummyData();
        ListNode.traverseList(head);
        System.out.println("----------");
        ListNode newHead = reverseList(head);
        ListNode.traverseList(newHead);
    }

    /*
    * This is iterative approach with single traversal
    * */
    public static ListNode reverseListIterative(ListNode current) {
        if(current == null || current.next == null)
                return current;

        ListNode prev = null;
        ListNode next = current.next;

        while(current != null){
            current.next = prev;

            prev = current;
            current = next;
            if(next != null )
                next = next.next;
        }
        return prev;
    }


    public static ListNode reverseList(ListNode current){
        if(current == null || current.next == null)
            return current;
        return reverseListRecursive(null,current,current.next);
    }

    public static ListNode reverseListRecursive(ListNode prev,ListNode current, ListNode last){
        if(current == null)
            return prev;
        current.next = prev;
        return reverseListRecursive(current,last,last==null?null:last.next);
    }
}
