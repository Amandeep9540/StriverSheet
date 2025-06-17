package binaryTree.medium;

import binaryTree.TreeNode;

public class BalanceBinaryTree110 {
    public static void main(String[] args) {
        System.out.println("isBalanced -- "+isBalanced(TreeNode.giveDummyTree()));
    }

    public static boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return maxDepth(root) == -1 ? false : true;
    }

    public static int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int right = maxDepth(root.right);
        int left = maxDepth(root.left);
        if(right == -1 || left == -1) return -1;
        if(Math.abs(right-left) > 1)return -1;
        return 1 + Math.max(right,left);
    }
}
