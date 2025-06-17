package binaryTree.hard;

import binaryTree.TreeNode;

public class CountCompleteTreeNode222 {
    public static void main(String[] args) {
        TreeNode node = TreeNode.giveDummyTree();
        TreeNode.printTree(node);
        System.out.println("count is -- "+countNodes(node));
    }

    public static int countNodes(TreeNode root) {
        if(root == null) return 0;

        TreeNode temp = root;
        int leftHeight = 0;
        while(temp.left != null){
            temp = temp.left;
            leftHeight++;
        }
        temp = root;
        int rightHeight = 0;
        while(temp.right != null){
            temp = temp.right;
            rightHeight++;
        }

        if(leftHeight == rightHeight) return (int)(Math.pow(2,leftHeight+1)) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
