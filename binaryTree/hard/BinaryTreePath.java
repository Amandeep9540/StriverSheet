package binaryTree.hard;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {
    public static void main(String[] args) {
        binaryTreePaths(TreeNode.giveDummyTree()).stream().forEach(s -> System.out.println(s));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null) return result;
        getPathOfLeafNode(root,new StringBuilder(),result);
        return result;
    }

    private static void getPathOfLeafNode(TreeNode root, StringBuilder stringBuilder, List<String> result) {
        if(root == null) return;
        if(root.left == null && root.right == null){
            stringBuilder.append(root.val);
            result.add(new String(stringBuilder));
            stringBuilder.setLength(stringBuilder.length()-String.valueOf(root.val).length());
            return;
        }

        stringBuilder.append(root.val+"->");
        getPathOfLeafNode(root.left,stringBuilder,result);

        getPathOfLeafNode(root.right,stringBuilder,result);
        stringBuilder.setLength(stringBuilder.length()-(2 + String.valueOf(root.val).length()));
    }
}
