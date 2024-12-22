package LinkedList.LearnDoublyLL;

public class Node {
    public int data;
    public Node prev;
    public Node next;
    public Node random;

    public Node(int x){
        this.data = x;
        this.next = null;
        this.prev = null;
    }

    public Node(int x,Node next){
        this.data = x;
        this.next = next;
        this.prev = null;
    }

    public static Node  constructDLL(int arr[]) {
        Node prev = null;
        Node head = null;
        for(int i=0;i< arr.length;i++){
            Node current = new Node(arr[i]);
            if(prev == null){
                head = current;
                prev = head;
            }else{
                //Map the
                current.prev = prev;
                prev.next = current;
            }
            prev = current;
        }
        return  head;
    }


    public static Node addNode(Node head, int p, int x) {
        Node temp = head;
        for(int i=0;i<p;i++){
            //  by using this loop we stand at node last node and then create and map.
            temp = temp.next;
        }
        Node current = new Node(x);
        current.next = temp.next;
        current.prev = temp;
        temp.next = current;
        return head == null ? current : head;
    }

    public static Node deleteNodeByValue(Node head, int x) {
        if(head.data == x)
            return head.next;
        Node temp = head;
        while(temp != null){
            if(temp.data == x){
                temp.prev.next = temp.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static Node deleteNode(Node head,int position){
        Node temp = head;
        if(position == 1){
            head.next.prev = null;
            return temp.next;
        }

        while(position > 0 ){
            //standing at to be deleted node
            position--;
            temp = temp.next;
        }
        if(temp.next == null){
            temp.prev.next = null;
        }else{
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
            return head;
    }


    public static DLLNode reverseDLL(DLLNode head){
     while(head  != null){
            DLLNode temp = head.next;
            head.next = head.prev;
            head.prev = temp;

            head = head.prev;
        }
        return head;
    }

    public static void traverseNode(Node head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void traverseNode(DLLNode head){
        DLLNode prev = null;
        while(head != null){
            System.out.print(head.data + " ");
            prev = head;
            head = head.next;
        }
            System.out.println();
        while(prev != null){
            System.out.print(prev.data + " ");
            prev = prev.prev;
        }
    }

    public static Node constructDLLWithRandomPointers(){
        Node five = new Node(5);
        Node four = new Node(4,five);
        Node third = new Node(3,four);
        Node second = new Node(2,third);
        Node head = new Node(1,second);
        head.random = four;
        second.random = third;
        third.random = head;
        four.random = head;
        five.random = third;
        return head;
    }


    public static void traverseWithRandomPointers(Node head) {
        while(head != null){
            System.out.println("data :: "+head.data+" random data :: "+(head.random != null ? head.random.data: -99));
            head = head.next;
        }
    }
}

