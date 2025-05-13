package linkedlist.MediumProbDLL;

import linkedlist.LearnDoublyLL.Node;

public class DeleteAllOccurenceOfNum {
    public static void main(String[] args) {
        Node node = Node.constructDLL(new int[]{1, 1, 2, 1, 4, 5});
        Node node1 = deleteAllOccurOfX(node, 1);
        Node.traverseNode(node1);
    }

    static Node deleteAllOccurOfX(Node head, int x) {

            //traverse till you find new head
        while (head.data == x){
            head = head.next;
        }

        Node newHead = head;

            //now traverse the list
        while(head != null){
                if(head.data == x){
                    Node prev = head.prev;
                    Node next = head.next;
                    prev.next = next;

                    if(next!= null) next.prev = prev;
                }
            head = head.next;
        }
        return newHead;
    }
}
