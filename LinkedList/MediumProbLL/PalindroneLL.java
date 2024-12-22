package LinkedList.MediumProbLL;

import LinkedList.ListNode;

import java.util.List;

public class PalindroneLL {
    public static void main(String[] args) {
        ListNode data = ListNode.constructDLL(new int[]{1,2});
 //       ListNode.traverseList(reverseLinkedList(ListNode.constructDLL(new int[]{1,3})));
        ListNode.traverseList(data);
        System.out.println();
        boolean palindrome = isPalindrome(data);
        System.out.println("list is palindrome :: "+palindrome);
    }

    public static boolean isPalindrome(ListNode head) {
            //find the middle one
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
            //reverse the second half of ll
        ListNode secondHalf = reverseLinkedList(slow);
            //compare until we reach null

        while(secondHalf != null && head != null){
            if(head.val != secondHalf.val)
                return false;
            head = head.next;
            secondHalf = secondHalf.next;
        }

            //again reverse the second half of ll to make it as given ll
        reverseLinkedList(slow);
        return true;
    }

    public static ListNode reverseLinkedList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = null;
        ListNode current = head;
        ListNode next = head.next;
            while(current != null){
                current.next = prev;
                prev = current;
                current = next;
                next = next == null ? null :next.next;
            }
        return prev;
    }
}
