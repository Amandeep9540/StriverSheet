package LinkedList.LearnDoublyLL;

public class MainCheck {
    public static void main(String[] args) {
//        Node head = Node.constructDLL(new int[]{1, 24, 5, 78, 99});
//        Node head2 = Node.deleteNode(head, 24);
//        Node.traverseNode(head2);
        DLLNode reverseList = DLLNode.reverseDLL(DLLNode.constructDLL(new int[]{1, 2, 3, 4, 5}));
        Node.traverseNode(reverseList);
    }
}
