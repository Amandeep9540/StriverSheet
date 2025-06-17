package binaryTree.medium;

import binaryTree.TreeNode;

public class BTMaximumPathSum142 {
    public static void main(String[] args) {
        System.out.println("max --> "+maxPathSum(TreeNode.giveDummyTree()));
    }

    static int maxSum = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        findPathSum(root);
        return maxSum;
    }

    public static int findPathSum(TreeNode root){
        if(root == null) return 0;
        int leftSum = Math.max(0,findPathSum(root.left));
        int rightSum = Math.max(0,findPathSum(root.right));
        maxSum = Math.max(maxSum,(root.val + leftSum + rightSum));
        return root.val + Math.max(leftSum,rightSum);
    }
}
