package LinkedList.MediumProbLL;

import LinkedList.ListNode;

public class InsertionOfTwoLL160 {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = getLength(headA);
        int l2 = getLength(headB);

        if(l1>l2){
            while(l1 != l2){
                headA = headA.next;
                l1--;
            }
        } else if (l2>l1) {
            while(l2 != l1){
                headB = headB.next;
                l2--;
            }
        }

        while(headA != null || headB != null){

                if(headA == headB){
                    return headA;
                }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    public int getLength(ListNode head){
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            len++;
        }
        return len;
    }


}
