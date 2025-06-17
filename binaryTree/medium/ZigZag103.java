package binaryTree.medium;

import binaryTree.TreeNode;

import java.util.*;

public class ZigZag103 {
    public static void main(String[] args) {
        zigzagLevelOrder(TreeNode.giveDummyTree()).stream().forEach(System.out::println);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        queue.add(root);
        boolean isReverseNeeded = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size-- > 0){
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                list.add(node.val);
            }
            if(isReverseNeeded){
                Collections.reverse(list);
                isReverseNeeded = false;
            }else{
                isReverseNeeded = true;
            }
            result.add(new ArrayList<>(list));
        }
        return result;
    }
}
