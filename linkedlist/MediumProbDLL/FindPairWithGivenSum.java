package linkedlist.MediumProbDLL;

import linkedlist.LearnDoublyLL.Node;

import java.util.ArrayList;

public class FindPairWithGivenSum {
    public static void main(String[] args) {
        Node head = Node.constructDLL(new int[]{1, 2, 3, 4, 5});
        ArrayList<ArrayList<Integer>> pairsWithGivenSum = findPairsWithGivenSum(5, head);
        System.out.println(pairsWithGivenSum);
    }

    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(head == null || head.next == null)
            return ans;

        Node right = head;
        while(right.next != null){
            right = right.next;
        }

        Node left = head;
        while(right.data > left.data){
                if(right.data + left.data == target){
                    ArrayList<Integer> tempAns = new ArrayList<>();
                    tempAns.add(right.data);
                    tempAns.add(left.data);
                    ans.add(tempAns);
                    right = right.prev;
                    left = left.next;
                }else if(right.data + left.data > target){
                    right = right.prev;
                }else{
                    left = left.next;
                }
        }

        return ans;
    }
}
