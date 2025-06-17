package binaryTree.hard;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversalInorder {
    public static void main(String[] args) {
        inoderTraversal(TreeNode.giveDummyTree()).stream().forEach(System.out::println);
    }

    public  static List<Integer> inoderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                list.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode predecessor = curr.left;
                while(predecessor.right != null && predecessor.right != curr){
                    predecessor = predecessor.right;
                }
                if(predecessor.right == null){
                    predecessor.right = curr;
                    curr = curr.left;
                }else{
                    predecessor.right = null;
                    list.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return list;
    }
}
