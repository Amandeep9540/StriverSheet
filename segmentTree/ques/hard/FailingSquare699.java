package segmentTree.ques.hard;

import java.util.ArrayList;
import java.util.List;

public class FailingSquare699 {
    public static void main(String[] args) {
        int[][] positions = {  // Expected Answer: [4, 7, 9]
                {2, 4},
                {4, 3},
                {3, 2}
        };

       Solution solu = new Solution();
        solu.fallingSquares(positions).stream().forEach(System.out::println);
    }
    static class Solution {
        public  List<Integer> fallingSquares(int[][] positions) {
            List<Integer> resultList = new ArrayList<>();
            SegmentTreeNode root = new SegmentTreeNode(0, (int) 1e8);
            for (int[] pos : positions) {
                int left = pos[0], right = pos[0] + pos[1] - 1;
                int baseHeight = query(left,right,root);
                update(left, right, baseHeight + pos[1], root);
                resultList.add(root.height);
            }
            return resultList;
        }

        public int query(int left,int right,  SegmentTreeNode node){
            populate(node, left, right);
            if (node == null || node.start > right || node.end < left) { //outof Range condition
                return 0;
            }
            if (left <= node.start && node.end <= right) { //inside the range condition ::
                return node.height;
            }
            int mid = (node.start + node.end) / 2;
            if (node.left == null) node.left = new SegmentTreeNode(node.start, mid);
            if (node.right == null) node.right = new SegmentTreeNode(mid + 1, node.end);

            int leftHeight = query(left,right,node.left);
            int rightHeight = query(left,right,node.right);
            return Math.max(leftHeight,rightHeight);
        }
        public void update(int left, int right, int height, SegmentTreeNode node) {
            populate(node, left, right);
            if (node == null || node.start > right || node.end < left) { //outof Range condition
                return;
            }
            if (left <= node.start && node.end <= right) { //inside the range condition ::
                node.height = height;
                node.isLazy = true;
                return;
            }

            if (node.start == node.end)
                return;
            int mid = (node.start + node.end) / 2;

            if (node.left == null)
                node.left = new SegmentTreeNode(node.start, mid);

            if (node.right == null)
                node.right = new SegmentTreeNode(mid + 1, node.end);

            update(left, right, height, node.left);
            update(left, right, height, node.right);

            node.height = Math.max(node.right.height, node.left.height);
        }

        private void populate(SegmentTreeNode node, int left, int right) {
            if (node == null || !node.isLazy)
                return;

            if (node.start != node.end) { // means we have child nodes
                //adding child nodes if those null
                int mid = (node.start + node.end) / 2;
                if (node.left == null)
                    node.left = new SegmentTreeNode(node.start, mid);
                if (node.right == null)
                    node.right = new SegmentTreeNode(mid + 1, node.end);

                node.left.height = node.height;
                node.right.height = node.height;

                node.left.isLazy = true;
                node.right.isLazy = true;
            }

            node.isLazy = false;
        }


    }

    static class SegmentTreeNode {
        int start;
        int end;

        SegmentTreeNode left;
        SegmentTreeNode right;

        int height;
        boolean isLazy;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}

