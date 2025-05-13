package stacks_queue.learning;

import java.util.Stack;

public class ImplementQueueUsingStack {
    public static void main(String[] args) {
        MyQueueUsingStack queue = new MyQueueUsingStack();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println("Top element :: "+queue.peek());
        queue.pop();
        System.out.println("new top element :: "+queue.peek());


    }
}

class MyQueueUsingStack {

    Stack<Integer> stack ;

    public MyQueueUsingStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        if(stack.isEmpty()) return -1;

        int[] tempArr = new int[stack.size()];
        int start = 0;
        while(!stack.isEmpty()){
            tempArr[start++] = stack.pop();
        }
        int n = tempArr.length - 2;
        while(n>=0){
            stack.add(tempArr[n--]);
        }
        return tempArr[tempArr.length-1];
    }

    public int peek() {
        if(stack.isEmpty()) return -1;
        int start = 0;
        int[] tempArr = new int[stack.size()];

        while(!stack.isEmpty()){
            tempArr[start++] = stack.pop();
        }
        int n = tempArr.length - 1;
        while(n>=0){
            stack.add(tempArr[n--]);
        }
        return tempArr[tempArr.length-1];
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
