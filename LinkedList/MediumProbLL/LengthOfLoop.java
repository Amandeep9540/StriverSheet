package LinkedList.MediumProbLL;

import LinkedList.LearnDoublyLL.Node;

public class LengthOfLoop {
    public static void main(String[] args) {

    }

    public int countNodesinLoop(Node head) {
        int count = 1;
        Node mettingPoint = null;

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow){
                mettingPoint = fast;
                break;
            }

        }

        if(mettingPoint == null)
            return 0;

        Node temp = mettingPoint;

        while(temp.next != mettingPoint){
            temp = temp.next;
            count++;
        }

        return count;
    }
}
