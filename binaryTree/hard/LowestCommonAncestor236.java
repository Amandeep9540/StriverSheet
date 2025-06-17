package binaryTree.hard;

import binaryTree.TreeNode;

public class LowestCommonAncestor236 {
    public static void main(String[] args) {

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == q || root == p) return root;
        TreeNode oneNode = lowestCommonAncestor(root.left,p,q);
        TreeNode secNode = lowestCommonAncestor(root.right,p,q);
        if(oneNode != null && secNode != null) return root;
        return oneNode == null ? secNode : oneNode;
    }
}
