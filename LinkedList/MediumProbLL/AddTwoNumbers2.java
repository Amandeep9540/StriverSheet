package LinkedList.MediumProbLL;

import LinkedList.ListNode;

public class AddTwoNumbers2 {
    public static void main(String[] args) {
        ListNode l1 = ListNode.constructDLL(new int[]{1, 2, 2});
        ListNode l2 = ListNode.constructDLL(new int[]{1, 2, 2, 9});

        ListNode add = addTwoNumbers(l1, l2);

        ListNode.traverseList(add);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null || l2 == null)
            return l1 == null ? l2 : l1;

        ListNode newHead = new ListNode(-1);
        ListNode headTemp  =newHead;
        int carrayValue = 0;
        while(l1 != null || l2 != null){
            ListNode temp = l1 == null ? l2 : l1;
            int total = getValue(l1) + getValue(l2) +carrayValue;

            if(total > 9) {
                carrayValue = total / 10;
                total = (total) % 10;
            }else{
                carrayValue = 0;
            }
            temp.val = total;
            headTemp.next = temp;
            headTemp = headTemp.next;

            if(l1 != null ) l1 = l1.next;
            if(l2 != null ) l2 = l2.next;
        }

        if(carrayValue > 0){
            headTemp.next = new ListNode(carrayValue);
        }

        return newHead.next;
    }

    public static int getValue(ListNode node){
        if(node != null ){
            return node.val;
        }
        return 0;
    }
}
