package binaryTree.traversals;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode node = TreeNode.giveDummyTree();
        inorderTraversalIterative(node).stream().forEach(System.out::println);
    }

        /*recursive*/
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root,result);
        return result;
    }

    public static void inorderTraversal(TreeNode root,List<Integer> result){
        if(root == null)
            return;

        inorderTraversal(root.left,result);
        result.add(root.val);
        inorderTraversal(root.right,result);
    }

        /*Iterative*/
    public static List<Integer> inorderTraversalIterative(TreeNode root){
        List<Integer> result = new ArrayList<>();
            if(root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(true){
            if(curr != null){
                stack.add(curr);
                curr = curr.left;
            }else{
                 if(stack.isEmpty()) break;
                curr = stack.pop();
                result.add(curr.val);
                curr = curr.right;
            }
        }
        return result;
    }
}
