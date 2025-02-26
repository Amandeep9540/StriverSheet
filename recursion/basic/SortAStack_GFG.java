package recursion.basic;

import java.util.List;
import java.util.Stack;

public class SortAStack_GFG {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.addAll(List.of(60, 20, 10, 80, 50));
        sort(stack);
        stack.stream().forEach(System.out::println);
    }

    public static Stack<Integer> sort(Stack<Integer> s) {
        if(s.isEmpty()){
            return s;
        }
        int topTemp = s.pop();
        sort(s);
        insertItemAtCorrectPlace(s,topTemp);
        return s;
    }

    private static void insertItemAtCorrectPlace(Stack<Integer> s, int item) {
        if(s.isEmpty() || s.peek() <= item){
            s.add(item);
        }else{
            int topTemp = s.pop();
            insertItemAtCorrectPlace(s,item);
            s.add(topTemp);
        }
    }

}
