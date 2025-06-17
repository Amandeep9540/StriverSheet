package binaryTree.hard;

import binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBT297 {
    public static void main(String[] args) {
        TreeNode node = TreeNode.giveDummyTree();
        TreeNode.printTree(node);
        String serializedString = serialize(node);
        System.out.println("serializedString --  "+serializedString);
        TreeNode deserializedNode = deserialize(serializedString);
        TreeNode.printTree(deserializedNode);
    }

    public static String serialize(TreeNode root) {
        if(root == null) return null;
        StringBuilder str = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        str.append(root.val+",");
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                TreeNode node = queue.poll();
                if(node.left != null){
                    str.append(node.left.val+",");
                    queue.add(node.left);
                }else{
                    str.append("?"+",");
                }
                if(node.right != null){
                    str.append(node.right.val+",");
                    queue.add(node.right);
                }else{
                    str.append("?"+",");
                }
            }
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data == null) return null;
        String[] arr = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        int i = 0;
        TreeNode root = new TreeNode(Integer.valueOf(arr[i++]));
        queue.add(root);
        while(i < arr.length && !queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode leftNode = null;
            if(!arr[i].equals("?")){
                leftNode = new TreeNode(arr[i].equals("?") ? null : Integer.valueOf(arr[i]));
                queue.add(leftNode);
            }
            i++;
            TreeNode rightNode = null;
            if(!arr[i].equals("?")){
                rightNode = new TreeNode(arr[i].equals("?") ? null : Integer.valueOf(arr[i]));
                queue.add(rightNode);
            }
            i++;
            node.left = leftNode;
            node.right = rightNode;
        }
        return root;
    }
}
