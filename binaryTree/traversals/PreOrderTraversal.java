package binaryTree.traversals;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
    public static void main(String[] args) {
         TreeNode node = TreeNode.giveDummyTree();
         preorderTraversal(node).stream().forEach(System.out::println);
    }

        /*recursive traversal*/
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root,result);
        return result;
    }
    public static void preorderTraversal(TreeNode root,List<Integer> result){
        if(root == null)
            return;

        result.add(root.val);
        preorderTraversal(root.left,result);
        preorderTraversal(root.right,result);
    }

         /*Iterative traversal*/
    public static List<Integer> preorderTraversalIterative(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
                if(node.right != null) stack.add(node.right);
                if(node.left != null) stack.add(node.left);
            result.add(node.val);
        }
        return result;
    }
}
