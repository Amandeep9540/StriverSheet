package binaryTree.hard;

import binaryTree.TreeNode;

import java.util.*;

public class AllNodeDistanceK863 {
    public static void main(String[] args) {
        TreeNode node = TreeNode.giveDummyTree();
        TreeNode.printTree(node);
        distanceK(node,node.left.left,2).stream().forEach(System.out::println);
    }


    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root == null) return new ArrayList<>();

        Map<TreeNode,TreeNode> mapParentChildNode = new HashMap<>();
        fillParentChildMapping(root,mapParentChildNode);
        Queue<TreeNode> queue =  new ArrayDeque<>();
        Set<TreeNode> visitedNode = new HashSet<>();
        queue.offer(target);
        visitedNode.add(target);
        while(k-- > 0){
            int size = queue.size();
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
        }
        return getValueFromQueue(queue);
    }

    private static List<Integer> getValueFromQueue(Queue<TreeNode> queue){
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            list.add(queue.poll().val);
        }
        return list;
    }
    private static void fillParentChildMapping(TreeNode root, Map<TreeNode, TreeNode> map){
        Queue<TreeNode> queue =  new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                TreeNode node = queue.poll();
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
    }
}
