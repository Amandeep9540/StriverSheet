package linkedlist.MediumProbDLL;

import linkedlist.LearnDoublyLL.Node;

public class RemoveDuplicatesFromSortedDLL_GFG {
    public static void main(String[] args) {

    }

    Node removeDuplicates(Node head){
        while(head.next != null){
            if(head.data == head.next.data){
                if(head.next.next != null) head.next.next.prev = head;
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }
        return head;
    }
}
