package linkedlist;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        this.val = x;
    }

    ListNode(int x,ListNode next) {
        this.val = x;
        this.next = next;
    }

    public static ListNode getDummyData(){
            ListNode lastNode  = new ListNode(30);
            ListNode secLast = new ListNode(25,lastNode);
            ListNode thirdLast = new ListNode(20,secLast);
            ListNode fourthLast = new ListNode(15,thirdLast);
            ListNode fifthLast = new ListNode(10,fourthLast);
            ListNode sixLast = new ListNode(5,fifthLast);
            ListNode head = new ListNode(0,sixLast);
        return head;
    }

    public static ListNode constructDLL(int arr[]) {
        ListNode head = new ListNode(arr[0]);
        ListNode prev = head;
        for(int i = 1;i< arr.length;i++){
            ListNode node = new ListNode(arr[i]);
            prev.next = node;
            prev = node;
        }
        return head;
    }

    public static void traverseList(ListNode head){
        while(head != null){
            System.out.print(head.val +" ");
            head = head.next;
        }
    }

    public static ListNode insertNode(ListNode head, int value, int position){
        ListNode newNode = new ListNode(value);

        if(position == 1){
            newNode.next = head;
            return newNode;
        }

        ListNode temp = head;
        int currentIn = 1;
        while(temp != null){
            if(currentIn == (position-1)){
                ListNode currTemp = temp.next;
                temp.next = newNode;
                newNode.next = currTemp;
            }
            temp = temp.next;
            position--;
        }
        return head;
    }

    public static ListNode deleteNodeByValue(ListNode head, int value){
        if(head.val == value){
            return head.next;
        }
        ListNode temp = head;
        while(temp.next != null){
            if(temp.next.val == value){
                ListNode nextValue = temp.next.next;
                temp.next = nextValue;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static ListNode deleteNodeByIndex(ListNode head,int index){
        if(index == 1)
            return head.next;
        ListNode temp = head;
        while(temp.next != null){
            if(index == 2){
                temp.next = temp.next.next;
            }
            index--;
            temp = temp.next;
        }
        return head;
    }
}
