package Strings.hard;

import java.util.ArrayDeque;
import java.util.Stack;

public class MinNoToMakeValidParenthese921 {
    public static void main(String[] args) {
       String str = "())";
        System.out.println("minAddToMakeValid -- "+minAddToMakeValid(str));

    }

    public static int minAddToMakeValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == '(' && c == ')'){
                stack.pop();
            }else{
                stack.push(c);
            }
        }

        return stack.size();
    }

}
