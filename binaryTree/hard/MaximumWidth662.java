package binaryTree.hard;

import binaryTree.TreeNode;

import java.util.ArrayDeque;

public class MaximumWidth662 {
    public static void main(String[] args) {
        System.out.println("width -> "+widthOfBinaryTree(TreeNode.giveDummyTree()));
    }

    public static int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        ArrayDeque<Tuple> queue = new ArrayDeque<>();
        long maxi = Integer.MIN_VALUE;

        queue.offer(new Tuple(root,0L));
        while(!queue.isEmpty()){
            Tuple first = queue.getFirst();
            Tuple last = queue.getLast();
            maxi = Math.max(maxi,(last.ind - first.ind)+1);
            int size = queue.size();
            while(size-- > 0){
                Tuple node = queue.poll();
                if(node.node.left != null)
                    queue.offer(new Tuple(node.node.left, (node.ind * 2) + 1));
                if(node.node.right != null)
                    queue.offer(new Tuple(node.node.right, (node.ind * 2) + 2));
            }
        }
        return (int) maxi;
    }

    static class Tuple{
        TreeNode node;
        long ind;
        public Tuple(TreeNode node,long ind){
            this.node = node;
            this.ind = ind;
        }
    }
}
