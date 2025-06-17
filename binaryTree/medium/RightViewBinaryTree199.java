package binaryTree.medium;

import binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RightViewBinaryTree199 {
    public static void main(String[] args) {
        rightSideView(TreeNode.giveDummyTree()).stream().forEach(System.out::println);
    }

    public static List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque();
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                TreeNode node = queue.poll();
                if(size == 0)
                    result.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
        }
        return result;
    }
}
