package LinkedList.HardProbLL;

public class FlatteningLinkedList_GFG {
    public static void main(String[] args) {
        Node nonFlattenLL = Node.createDummyData();
        Node flattenLL = flatten(nonFlattenLL);
        Node.traverseNode(flattenLL);
    }

    public static Node flatten(Node root) {
        if(root == null || root.next == null ){
            return root;
        }
        Node current = root.next;
        Node prev = root;
        Node newHead = null;
        while(current != null){
            Node nextNode = current.next;
            current.next = null;
            prev.next = null;
            prev = mergeTwoSortedList(current, prev);
            current = nextNode;
            if(newHead == null)
                newHead = prev;
        }
        return newHead;
    }

    public static Node mergeTwoSortedList(Node list1,Node list2){
        if(list1 == null || list2 == null){
            return list1 == null ? list2 : list1;
        }
        Node head = new Node(-1);
        Node headOri = head;
        while(list1 != null && list2 != null){
            if(list1.data > list2.data){
                head.bottom = list2;
                list2 = list2.bottom;
            }else{
                head.bottom = list1;
                list1 = list1.bottom;
            }
            head = head.bottom;
        }

        if(list1 != null){
            head.bottom = list1;
        }else if(list2 != null){
            head.bottom = list2;
        }

        return headOri.bottom;
    }
}

class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x){
        data = x;
        next = null;
        bottom = null;
    }

    public static Node createDummyData(){
        Node head = new Node (5);
        Node sec = new Node (10);
        Node third = new Node (19);
        Node four = new Node (28);

        head.next = sec;
        sec.next = third;
        third.next = four;

        Node headBottom1 = new Node(7);
        Node headBottom2 = new Node(8);
        Node headBottom3 = new Node(30);

        head.bottom = headBottom1;
        headBottom1.bottom = headBottom2;
        headBottom2.bottom = headBottom3;

        Node secBottom1 = new Node(20);
        sec.bottom = secBottom1;

        Node thirdBottom1 = new Node(22);
        Node thirdBottom2 = new Node(50);

        third.bottom = thirdBottom1;
        thirdBottom1.bottom = thirdBottom2;

        return head;
    }

    public static void traverseNode(Node node){
        while(node != null){
            System.out.print(" "+node.data);
            node = node.bottom;
        }
    }
}
