package binaryTree.medium;

import binaryTree.TreeNode;

public class SameTree100 {
    public static void main(String[] args) {
        System.out.println("is same -->"+isSameTree(TreeNode.giveDummyTree(),TreeNode.giveDummyTree()));
    }

    public static boolean isSameTree(TreeNode node1, TreeNode node2) {
        if(node1 == null || node2 == null)
            return node1 == node2;
        boolean leftSame = isSameTree(node1.left,node2.left);
        boolean rightSame = isSameTree(node1.right,node2.right);
        return node1.val == node2.val && (leftSame && rightSame);
    }
}
