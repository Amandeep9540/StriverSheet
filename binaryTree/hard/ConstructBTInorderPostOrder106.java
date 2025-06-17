package binaryTree.hard;

import binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTInorderPostOrder106 {
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode node = buildTree(inorder, postorder);
        TreeNode.printTree(node);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root = buildTree(postorder,postorder.length-1,0 , inorder,0,inorder.length-1,map);
        return root;
    }

    private static TreeNode buildTree(int[] postorder, int postSt, int postEnd, int[] inorder, int inSt, int inEnd, Map<Integer,Integer> map){
        if(postSt < 0 || inSt > inEnd) return null;
        TreeNode root = new TreeNode(postorder[postSt]);

        int rootInd = map.get(postorder[postSt]);
        int nodeRight = inEnd - rootInd;

        root.right = buildTree(postorder,postSt-1,postSt-nodeRight,inorder,rootInd+1,inEnd,map);
        root.left = buildTree(postorder,postSt - nodeRight -1,postEnd,inorder,inSt,rootInd-1,map);
        return root;
    }
}
