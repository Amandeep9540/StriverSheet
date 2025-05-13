package linkedlist.LearnDoublyLL;

public class DLLNode {
        int data;
        linkedlist.LearnDoublyLL.DLLNode next;
        linkedlist.LearnDoublyLL.DLLNode prev;

        DLLNode(int val) {
            data = val;
            next = null;
            prev = null;
        }

    public static DLLNode  constructDLL(int arr[]) {
        DLLNode prev = null;
        DLLNode head = null;
        for(int i=0;i< arr.length;i++){
            DLLNode current = new DLLNode(arr[i]);
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

    public static DLLNode reverseDLL(DLLNode head){
            DLLNode last = null;
        while(head.next  != null){

            last = head.prev;
            head.prev = head.next;
            head.next = last;
            head = head.prev;
        }
        return last;
    }
}
