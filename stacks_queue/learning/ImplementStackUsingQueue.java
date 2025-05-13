package stacks_queue.learning;

import java.util.ArrayDeque;
import java.util.Queue;

public class ImplementStackUsingQueue {
    public static void main(String[] args) {
        MyStackUsingQueue stack = new MyStackUsingQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Pop Element :: "+stack.pop());
        System.out.println("new top element :: "+stack.top());
    }
}

class MyStackUsingQueue {
    Queue<Integer> queue;
    public MyStackUsingQueue() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        if(queue.isEmpty()) return -1;
        int[] tempArr = new int[queue.size()];
        int start = 0;
        while(!queue.isEmpty()){
            tempArr[start++] =queue.poll();
        }
        for(int i=0;i<tempArr.length-1;i++){
            queue.add(tempArr[i]);
        }
        return tempArr[tempArr.length-1];
    }

    public int top() {
        if(queue.isEmpty()) return -1;

        int[] tempArr = new int[queue.size()];
        int start = 0;
        while(!queue.isEmpty()){
            tempArr[start++] =queue.poll();
        }
        for (int j : tempArr) {
            queue.add(j);
        }
        return tempArr[tempArr.length-1];
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
