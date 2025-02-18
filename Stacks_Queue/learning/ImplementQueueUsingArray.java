package Stacks_Queue.learning;

public class ImplementQueueUsingArray {
    public static void main(String[] args) {
        MyQueue.main(null);
    }
}
class MyQueue {

    int front, rear,capcity;
    int[] arr = new int[5];

    MyQueue()
    {
        front=0;
        rear=0;
        capcity=0;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(5);
        myQueue.push(4);
        myQueue.push(3);
        myQueue.push(2);
        myQueue.push(1);

        int pop1 = myQueue.pop();
        System.out.println("Pop 1 :: "+pop1);
        int pop2 = myQueue.pop();
        System.out.println("Pop 2 :: "+pop2);

        myQueue.push(6);
        myQueue.push(7);
        myQueue.push(8);
        while(myQueue.capcity != 0) {
            System.out.println("element inside the loop is :: "+myQueue.pop());
        }
    }


    void push(int x)
    {
        if(capcity >= arr.length){
            System.out.println("Queue Overflow item "+x+" can't be pushed");
            return;
        }
        arr[rear]=x;
        rear = (rear + 1) % arr.length;
        capcity++;
    }

    int pop()
    {
        if(capcity == 0){
            System.out.println("Queue Underflow");
            return -1;
        }
        int pop = arr[front];
        front = (front + 1) % arr.length;
        capcity--;
        return pop;
    }
}
