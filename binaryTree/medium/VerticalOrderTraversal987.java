package binaryTree.medium;

import binaryTree.TreeNode;

import java.util.*;

public class VerticalOrderTraversal987 {
    public static void main(String[] args) {
        verticalTraversal(TreeNode.giveDummyTree()).stream().forEach(System.out::println);
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Tuple> queue = new ArrayDeque<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        queue.offer(new Tuple(root,0,0));

        while(!queue.isEmpty()){
            Tuple tuple = queue.poll();
            //Adding data in queue
            if(tuple.node.left != null){
                queue.offer(new Tuple(tuple.node.left,tuple.col-1,tuple.row+1));
            }
            if(tuple.node.right != null){
                queue.offer(new Tuple(tuple.node.right,tuple.col+1,tuple.row+1));
            }
            //putting details in map
            if (!map.containsKey(tuple.col)) {
                map.put(tuple.col, new TreeMap<>());
            }
            if (!map.get(tuple.col).containsKey(tuple.row)) {
                map.get(tuple.col).put(tuple.row, new PriorityQueue<>());
            }
            map.get(tuple.col).get(tuple.row).offer(tuple.node.val);

        }

        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            List<Integer> colList = new ArrayList<>();
            for (PriorityQueue<Integer> pq : ys.values()) {
                while (!pq.isEmpty()) {
                    colList.add(pq.poll());
                }
            }
            result.add(colList);
        }

        return result;
    }
}

class Tuple{
    TreeNode node;
    int col;
    int row;
    public Tuple(TreeNode node,int col,int row){
        this.node = node;
        this.col = col;
        this.row = row;
    }
}
