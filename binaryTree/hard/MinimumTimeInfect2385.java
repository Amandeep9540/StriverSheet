package binaryTree.hard;

import binaryTree.TreeNode;

import java.util.*;

public class MinimumTimeInfect2385 {
    public static void main(String[] args) {
        System.out.println("time needed -- "+amountOfTime(TreeNode.giveDummyTree(),3));
    }

    public static int amountOfTime(TreeNode root, int start) {
        Map<TreeNode,TreeNode> mapParentChildNode = new HashMap<>();
        TreeNode targetAdd = fillParentChildMapping(root,start,mapParentChildNode);
        Queue<TreeNode> queue =  new ArrayDeque<>();
        Set<TreeNode> visitedNode = new HashSet<>();
        queue.offer(targetAdd);
        visitedNode.add(targetAdd);
        int k = 0;
        while(k > -1){
            int size = queue.size();
            if(size == 0) break;
            while(size-- > 0){
                TreeNode node = queue.poll();

                // insert the parent node
                if(mapParentChildNode.containsKey(node) && !visitedNode.contains(mapParentChildNode.get(node))){
                    queue.offer(mapParentChildNode.get(node));
                }
                // insert the left child
                if(node.left != null && !visitedNode.contains(node.left)){
                    queue.offer(node.left);
                }
                // insert the right child
                if(node.right != null && !visitedNode.contains(node.right)){
                    queue.offer(node.right);
                }
                visitedNode.add(node);
            }
            k++;
        }
        return k-1;
    }

    private static TreeNode fillParentChildMapping(TreeNode root,int startValue, Map<TreeNode, TreeNode> map){
        Queue<TreeNode> queue =  new ArrayDeque<>();
        queue.offer(root);
        TreeNode startAdd = null;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                TreeNode node = queue.poll();
                if(node.val == startValue) startAdd = node;
                if(node.left != null){
                    queue.offer(node.left);
                    map.put(node.left,node);
                }
                if(node.right != null){
                    queue.offer(node.right);
                    map.put(node.right,node);
                }
            }
        }

        return startAdd;
    }
}
