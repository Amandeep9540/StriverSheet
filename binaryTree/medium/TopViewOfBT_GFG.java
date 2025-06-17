package binaryTree.medium;

import binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfBT_GFG {
    public static void main(String[] args) {
        topView(Node.giveDummyTree()).stream().forEach(System.out::println);
    }

    static ArrayList<Integer> topView(Node root) {
        Queue<Tuple> queue = new ArrayDeque<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();

        queue.offer(new Tuple(0,root));
        while(!queue.isEmpty())
        {
            Tuple tuple = queue.poll();

            if(tuple.node.left != null)
                queue.offer(new Tuple(tuple.col-1,tuple.node.left));
            if(tuple.node.right != null)
                queue.offer(new Tuple(tuple.col+1,tuple.node.right));

            if(!map.containsKey(tuple.col))
                map.put(tuple.col,tuple.node.data);
        }
        return new ArrayList<>(map.values());
    }

     static class Tuple{
        Node node;
        int col;
        public Tuple(int col,Node node){
            this.col = col;
            this.node = node;
        }
    }
}


