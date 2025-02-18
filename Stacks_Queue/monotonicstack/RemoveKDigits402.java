package Stacks_Queue.monotonicstack;

import java.util.Stack;

public class RemoveKDigits402 {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println("smallest number :: "+removeKdigits(num,k));
    }

    public static String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for(char c:num.toCharArray()){
            //validate the stack
            while(!stack.isEmpty() && k > 0 && Character.getNumericValue(c) < Character.getNumericValue(stack.peek())){
                stack.pop();
                k--;
            }

            //add to stack
            stack.add(c);
        }

        //check if k have some value
        while(k>0){
            stack.pop();
            k--;
        }

        while(!stack.isEmpty()){
            ans.insert(0,stack.peek());
            int value = stack.pop();
            if(value == 0)
                break;
        }

        //remove the leading zeros
        while(ans.length() != 0){
            if(Character.getNumericValue(ans.charAt(0)) == 0){
                ans.deleteCharAt(0);
            }else{
                break;
            }
        }

        return ans.length() == 0 ? "0" : ans.toString();
    }
}
