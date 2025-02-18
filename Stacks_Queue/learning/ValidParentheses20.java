package Stacks_Queue.learning;

import java.util.Stack;

public class ValidParentheses20 {
    public static void main(String[] args) {
        String str = "()[]{}";
        System.out.println("Is above string is valid :: "+isValid(str));
    }

    public static boolean isValid(String s) {
        if(s.length() <= 1) return false;

        Stack<Character> stack = new Stack<>();
        for(Character c:s.toCharArray()){
            if((c == '(' || c == '{' || c == '[') || stack.isEmpty())
                stack.add(c);
            else if ((c == ')' && stack.peek() == '(') ||
                    (c == ']' && stack.peek() == '[') ||
                    (c == '}' && stack.peek() == '{') )
                stack.pop();
            else
                stack.add(c);
        }

        return stack.isEmpty();
    }
}
