package binaryTree.hard;

import binaryTree.TreeNode;

public class FlatternBT144 {
    public static void main(String[] args) {
        TreeNode node = TreeNode.giveDummyTree();
        flatten(node);
        while(node != null){
            System.out.println(node.val);
            node = node.right;
        }
    }

    public static void flatten(TreeNode root) {
        TreeNode curr = root;
        while(curr != null){
            if(curr.left != null){
                TreeNode temp = curr.left;
                while(temp.right != null){
                    temp = temp.right;
                }
                temp.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}
