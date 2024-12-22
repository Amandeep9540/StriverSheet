package LinkedList.HardProbLL;

import LinkedList.ListNode;

public class RotateList61 {
    public static void main(String[] args) {
        ListNode listHead = ListNode.constructDLL(new int[]{0,1,2});
        ListNode newHead = rotateRight(listHead, 6);
        ListNode.traverseList(newHead);
    }


    public static ListNode rotateRight(ListNode head, int k) {
            ListNode tempHead = head;
            ListNode lastNode = null;
            int length = 0;
            while(tempHead != null){
                length++;
                lastNode = tempHead;
                tempHead = tempHead.next;
            }

        int rotateBy = k%length;
            if(rotateBy == 0) return head;
        System.out.println("rotateBy"+rotateBy);
        tempHead = head;
        int runTill = (length - rotateBy);
        while(runTill-- > 1){
            tempHead = tempHead.next;
        }
        ListNode newHead = tempHead.next;
        tempHead.next = null;
        lastNode.next = head;

        return newHead;
    }

}
