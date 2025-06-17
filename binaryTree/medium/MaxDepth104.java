package binaryTree.medium;

import binaryTree.TreeNode;

public class MaxDepth104 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.giveDummyTree();
        System.out.println("max Depth --> "+maxDepth(treeNode));
    }
    public static int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int right = maxDepth(root.right);
        int left = maxDepth(root.left);
        return 1 + Math.max(right,left);
    }
}
