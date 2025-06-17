package binaryTree.hard;

import binaryTree.TreeNode;

public class ConvertToChildSumPropertry_ {
    public static void main(String[] args) {
        TreeNode node = TreeNode.giveDummyTree();
        TreeNode.printTree(node);
        System.out.println("changing the tree\n\n");
        changeTree(node);
        TreeNode.printTree(node);
    }

    public static void changeTree(TreeNode root){
        if(root == null) return;

        int childSum = 0;
        if(root.left != null)
            childSum += root.left.val;
        if(root.right != null)
            childSum += root.right.val;

        if(childSum >= root.val)
            root.val = childSum;
        else{
            if(root.left != null) root.left.val = root.val;
            if(root.right != null) root.right.val = root.val;
        }

        changeTree(root.left);
        changeTree(root.right);

        int updatedChildSum = 0;
        if(root.left != null)
            updatedChildSum += root.left.val;
        if(root.right != null)
            updatedChildSum += root.right.val;

        if(root.left != null || root.right != null)
            root.val = updatedChildSum;
    }
}
