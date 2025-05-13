package stacks_queue.learning;

public class ImplementStackUsingArray {
    public static void main(String[] args) {
        MyStack.main(null);
    }
}

class MyStack {
    private int[] arr;
    private int top;

    public static void main(String[] arrs){
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        int pop1 = stack.pop();
        System.out.println("pop1: " + pop1);
        int pop2 = stack.pop();
        System.out.println("pop1: " + pop2);

        for(int i=0;i<=stack.top;i++)
            System.out.println("stack: " + stack.arr[i]);
    }

    public MyStack() {
        arr = new int[1000];
        top = -1;
    }

    public void push(int x) {
        if(top >= 1000)
            System.out.println("Stack overflow");
        arr[++top] = x;
    }

    public int pop() {
        if(top == -1)
        {
            System.out.println("Stack underflow");
            return -1;
        }
        return arr[top--];
    }
}