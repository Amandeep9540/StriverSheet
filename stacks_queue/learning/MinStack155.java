package stacks_queue.learning;

import java.util.Stack;

public class MinStack155 {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Min value in stack is :: "+stack.getMin());
    }
}

class MinStack {

    Stack<Pair> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        int min = val;
        if(!stack.isEmpty()) {
            Pair peekEle = stack.peek();
            min = Math.min(peekEle.minValue,val);
        }
        stack.add(new Pair(val,min));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return  stack.peek().value;
    }

    public int getMin() {
        return  stack.peek().minValue;
    }
}

class Pair{
    int value;
    int minValue;

    public Pair(int value,int minValue){
        this.value = value;
        this.minValue = minValue;
    }
}
