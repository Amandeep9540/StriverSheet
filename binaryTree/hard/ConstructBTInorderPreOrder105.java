package binaryTree.hard;

import binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTInorderPreOrder105 {
    public static void main(String[] args) {
        int[] preOrder = {3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};
        TreeNode node = buildTree(preOrder, inOrder);
        TreeNode.printTree(node);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root = buildTree(preorder,0,preorder.length-1 , inorder,0,inorder.length-1,map);
        return root;
    }

    private static TreeNode buildTree(int[] preorder,int preSt,int preEnd,int[] inorder,int inSt,int inEnd,Map<Integer,Integer> map){
        if(preSt > preEnd || inSt > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preSt]);
        int rootInd = map.get(preorder[preSt]);
        int numsLeft = rootInd - inSt;

        root.left = buildTree(preorder,preSt+1,preSt+numsLeft, inorder,inSt,rootInd-1,map);
        root.right = buildTree(preorder,preSt+numsLeft+1,preEnd, inorder,rootInd+1,inEnd,map);
        return root;
    }
}
