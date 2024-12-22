package LinkedList.HardProbLL;

import LinkedList.ListNode;

public class ReverseGroupInKGroup25 {
    public static void main(String[] args) {
        ListNode head = ListNode.constructDLL(new int[]{1, 2, 3, 4, 5});
        ListNode newHead = reverseKGroup(head, 2);
        ListNode.traverseList(newHead);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        int len = getLength(head);
        int reversal = len / k;
        ListNode newHead = null;
        ListNode groupPrevTail = null;

        while(reversal-- > 0){
            ListNode tempListHead = head;
            int temp = k;

            while (temp-- > 1) {
                head = head.next;
            }

            ListNode tempListTail = head;
            head = head.next;
            tempListTail.next = null;


                    // Reverse the links in the current group
            ListNode prevRev = null;
            ListNode currentRev = tempListHead;
            ListNode nextRev;

            while (currentRev != null) {
                nextRev = currentRev.next;
                currentRev.next = prevRev;
                prevRev = currentRev;
                currentRev = nextRev;
            }
                //Reverse links code end

            if (newHead == null) {
                newHead = prevRev;
            }

            if (groupPrevTail != null) {
                groupPrevTail.next = prevRev;
            }

            groupPrevTail = tempListHead;
            tempListHead.next = head;

        }

        return newHead == null ? head : newHead;
    }

    public static int getLength(ListNode head){
        int len = 0;
        while(head != null){
            head = head.next;
            len++;
        }
        return len;
    }
}
