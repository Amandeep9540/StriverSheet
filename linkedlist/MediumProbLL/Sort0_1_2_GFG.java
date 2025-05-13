package linkedlist.MediumProbLL;

import linkedlist.LearnDoublyLL.Node;

public class Sort0_1_2_GFG {
    public static void main(String[] args) {
        Node node = Node.constructDLL(new int[]{0, 0, 0, 0 ,0, 0, 0});
        Node.traverseNode(node);
        System.out.println();
        Node node1 = segregate(node);
        Node.traverseNode(node1);
    }
    static Node segregate(Node head) {
        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);

        Node zeroTemp = zeroHead;
        Node oneTemp = oneHead;
        Node twoTemp = twoHead;

        while(head != null){
                if(head.data == 0){
                    zeroTemp.next = head;
                    zeroTemp = zeroTemp.next;
                }else if(head.data == 1){
                    oneTemp.next = head;
                    oneTemp = oneTemp.next;
                }else if(head.data == 2){
                    twoTemp.next = head;
                    twoTemp = twoTemp.next;
                }
          head = head.next;
        }

        zeroTemp.next = null;
        oneTemp.next = null;
        twoTemp.next = null;

        if(zeroHead.next != null){
            if(oneHead.next != null){
                zeroTemp.next = oneHead.next;
                oneTemp.next = twoHead.next;
            }else{
                zeroTemp.next = twoHead.next;
            }
            return zeroHead.next;
        }else{
            if(oneHead.next == null){
                return twoHead.next;
            }else{
                oneTemp.next = twoHead.next;
                return oneHead.next;
            }
        }

    }
}
