package stacks_queue.implementproblem;


import java.util.*;

public class OnlineStockSpan901 {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // return 1
        System.out.println(stockSpanner.next(80));  // return 1
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(70));  // return 2
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(75));  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
        System.out.println(stockSpanner.next(85));  // return 6
    }
}

class StockSpanner {

    Stack<Integer> stack ;
    List<Integer> ngl;
    List<Integer> priceList;

    public StockSpanner() {
        stack = new Stack<>();
        ngl = new ArrayList<>();
        priceList = new ArrayList<>();
    }

    public int next(int price) {
        while(!stack.isEmpty() && priceList.get(stack.peek()) <= price){
            stack.pop();
        }
        //add element
        ngl.add(stack.isEmpty() ? -1 : stack.peek());
        stack.add(priceList.size());
        priceList.add(price);
        return (priceList.size()-1) - ngl.get(priceList.size()-1) ;
    }
}
