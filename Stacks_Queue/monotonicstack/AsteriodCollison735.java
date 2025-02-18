package Stacks_Queue.monotonicstack;

import java.util.Stack;

public class AsteriodCollison735 {
    public static void main(String[] args) {
        int[] asteroids ={10,2,-5};
        int[] remainingAsteroids = asteroidCollision(asteroids);
        for(int ele:remainingAsteroids){
            System.out.print(" "+ele);
        }
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int ele:asteroids){
            if(ele > 0){
                stack.add(ele);
            }else{
                //validate the stack
                boolean isCurrentAsteroidLive = true;
                while(!stack.isEmpty() && stack.peek() > 0){
                    Integer peek = stack.peek();
                    if(peek > Math.abs(ele)){ // current asteriod mar gaya
                        isCurrentAsteroidLive = false;
                        break;
                    }else if(peek < Math.abs(ele)){ // stack asteriod mar gaya
                        stack.pop();
                    }else{ //current and stack dono mar gaye
                        isCurrentAsteroidLive = false;
                        stack.pop();
                        break;
                    }
                }

                if(isCurrentAsteroidLive)
                    stack.add(ele);

            }
        }

        int[] remainingAsteroids = new int[stack.size()];
        for(int i=remainingAsteroids.length-1;i>=0;i--){
            remainingAsteroids[i] = stack.pop();
        }
        return remainingAsteroids;
    }
}
