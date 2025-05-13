package linkedlist.HardProbLL;

import linkedlist.LearnDoublyLL.Node;

public class CopyListWithRandomPointer138 {
    public static void main(String[] args) {
        Node head = Node.constructDLLWithRandomPointers();
        Node.traverseWithRandomPointers(head);
        Node head2 = copyRandomList(head);
        System.out.println("-----------------------");
        Node.traverseWithRandomPointers(head2);
    }
    public static Node copyRandomList(Node head) {
            //Create a copy value node after every original node
        Node temp = head;
        while(temp != null){
            Node copyNode = new Node(temp.data);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }

            //Now map the random nodes
        temp = head;
        while(temp != null){
            if(temp.next != null & temp.random != null)
                temp.next.random = temp.random.next;
            temp = temp.next.next;
        }

            //Now destroy the link of original/given nodes
        temp = head.next;
        while(temp.next != null){
            Node secondOriNode = temp.next.next;
            if(temp.next != null) temp.next = temp.next.next;
            temp = secondOriNode;
        }

        return head.next;
    }
}
