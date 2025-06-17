package binaryTree.traversals;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostTraversal {
    public static void main(String[] args) {
        TreeNode node = TreeNode.giveDummyTree();
        postorderTraversal(node).stream().forEach(System.out::println);
    }

        /*Recursive*/
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root,result);
        return result;
    }
    public static void postorderTraversal(TreeNode root,List<Integer> result){
        if(root == null)
            return;

        postorderTraversal(root.left,result);
        postorderTraversal(root.right,result);
        result.add(root.val);
    }

        /*Iterative*/
    public static List<Integer> postorderTraversalIterativeV1(TreeNode node){
        List<Integer> result = new ArrayList<>();
            if(node == null ) return result;
        Stack<TreeNode> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        st1.add(node);
        while(!st1.isEmpty()){
            TreeNode curr = st1.pop();
                if(curr.right != null) st1.add(curr.right);
                if(curr.left != null) st1.add(curr.left);
            st2.add(curr.val);
        }
        while (!st2.isEmpty()){
            result.add(st2.pop());
        }
        return result;
    }

    public static List<Integer> postorderTraversalIterativeV2(TreeNode root){
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                result.addFirst(current.val);
                current = current.right;
            } else {
                TreeNode node = stack.pop();
                current = node.left;
            }
        }
        return result;
    }
}
