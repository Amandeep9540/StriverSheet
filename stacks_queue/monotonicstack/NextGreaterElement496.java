package stacks_queue.monotonicstack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement496 {
    public static void main(String[] args) {
        int[] arr1 = {4,1,2};
        int[] arr2 = {1,3,4,2};

        int[] greaterElement = nextGreaterElement(arr1, arr2);
            for(int ele:greaterElement){
                System.out.print(" "+ele);
            }
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> nums1Map = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            nums1Map.put(nums1[i],i);
        }
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums1.length];
        for(int i=nums2.length-1;i>=0;i--){
            int currentEle = nums2[i];
            //maintaining stack
            if(!stack.isEmpty() && currentEle > stack.peek()){
                while (!stack.isEmpty() && stack.peek() < currentEle){
                    stack.pop();
                }
            }
            //check currentEle is present in nums1
            if(nums1Map.containsKey(currentEle)){
                result[nums1Map.get(currentEle)] = stack.isEmpty() ? -1 : stack.peek();
            }
            //add current ele in stack
            stack.add(currentEle);
        }

        return result;
    }
}
