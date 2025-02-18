package Stacks_Queue.learning;

public class ImplementStackUsingLL {
    public static void main(String[] args) {
        MyStackUsingLL stack = new MyStackUsingLL();

        stack.push(1);
        stack.push(3);
        stack.push(5);

        System.out.println("stack top element is :: "+ stack.top.data);
        stack.pop();
        System.out.println("new stack top element is :: "+ stack.top.data);
    }


}

class MyStackUsingLL {
     class StackNode {
         int data;
         StackNode next;
         StackNode(int a) {
             data = a;
             next = null;
         }
     }
    StackNode top;

    // Function to push an integer into the stack.
    void push(int a) {
        StackNode current = new StackNode(a);
        if(top == null)
            top = current;
        else{
            current.next = top;
            top = current;
        }
    }

    // Function to remove an item from top of the stack.
    int pop() {
        if(top == null) return -1;
        int value = top.data;
        top = top.next;
        return value;
    }
}