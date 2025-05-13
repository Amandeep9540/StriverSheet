package linkedlist.MediumProbLL;

import linkedlist.LearnDoublyLL.Node;

public class AddOnesInLL_GFG {
    public static void main(String[] args) {
        Node data = Node.constructDLL(new int[]{9,9,8});
        Node node = addOne(data);
        Node.traverseNode(node);
    }

    public static Node addOne(Node head) {
        Node firstNonNine = null;
        Node temp = head;

        while(temp != null){
            if(temp.data != 9){
                firstNonNine = temp;
            }
            temp = temp.next;
        }

        if(null == firstNonNine){
            Node newHead = new Node(1);
            newHead.next = head;
            firstNonNine = head;
            head = newHead;
        }else{
            firstNonNine.data = firstNonNine.data + 1;
            firstNonNine = firstNonNine.next;
        }

        while(firstNonNine != null){
            firstNonNine.data = 0;
            firstNonNine = firstNonNine.next;
        }

        return head;
    }
}
