package binaryTree.medium;

import binaryTree.TreeNode;

public class DiameterOfTree543 {
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        System.out.println("diameter -- "+diameterOfBinaryTree(TreeNode.giveDummyTree()));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        maxDepth(root);
        return max;
    }

    public static int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int right = maxDepth(root.right);
        int left = maxDepth(root.left);
        max = Math.max(max,right+left);
        return 1 + Math.max(right,left);
    }
}
