package LinkedList.Learn1DLL;

import LinkedList.ListNode;

public class MainCheck {
    public static void main(String[] args) {
        ListNode head = ListNode.getDummyData();
        System.out.println("\ntraversing the dummy list");
        ListNode.traverseList(head);
        System.out.println("\ninsert the data in list");
        ListNode newHead = ListNode.insertNode(head, 35, 8);
        ListNode.traverseList(newHead);
        System.out.println("\ndelete the element in list by value");
        ListNode newHead2 = ListNode.deleteNodeByValue(newHead, 35);
        ListNode.traverseList(newHead2);
        System.out.println("\ndelete the element in list by index");
        ListNode newHead3 = ListNode.deleteNodeByIndex(newHead, 3);
        ListNode.traverseList(newHead3);
    }
}
