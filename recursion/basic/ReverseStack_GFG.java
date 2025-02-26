package recursion.basic;

import java.util.List;
import java.util.Stack;

public class ReverseStack_GFG {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.addAll(List.of(10,20,30,40,50));
        reverse(stack);
        stack.stream().forEach(System.out::println);
    }

    static void reverse(Stack<Integer> s)
    {
        if(s.isEmpty()){
            return;
        }
        int topEle = s.pop();
        reverse(s);
        insertAtBottom(s,topEle);
    }

    private static void insertAtBottom(Stack<Integer> s, int topEle) {
        if(s.isEmpty()){
            s.add(topEle);
            return;
        }
        int tempTopEle = s.pop();
        insertAtBottom(s,topEle);
        s.add(tempTopEle);
    }
}
