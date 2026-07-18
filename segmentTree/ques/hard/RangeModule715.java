package segmentTree.ques.hard;

public class RangeModule715 {
    public static void main(String[] args) {
        addRange(1,8);
        removeRange(3,5);
        System.out.println("1-"+queryRange(6,9));
        System.out.println("2-"+queryRange(2,9));
        addRange(2,6);
        System.out.println("3-"+queryRange(2,8));
    }

    static Node root  = new Node(1, (int)1e9);

    public static  void addRange(int left, int right) {
        update(root, left, right - 1, true);
    }

    public static  void removeRange(int left, int right) {
        update(root, left, right - 1, false);
    }

    public static  boolean queryRange(int left, int right) {
        return query(root, left, right - 1);
    }

    private static  void update(Node node, int l, int r, boolean value) {
        if (node == null || l > node.end || r < node.start)
            return;

        if (l <= node.start && node.end <= r) {
            node.val = value;
            node.isUniform = true;
            node.left = null;
            node.right = null;
            return;
        }

        push(node);

        update(node.left, l, r, value);
        update(node.right, l, r, value);

        pull(node);
    }

    private static boolean query(Node node, int l, int r) {
        if (node == null)
            return false;

        if (l > node.end || r < node.start)
            return true;

        if (node.isUniform)
            return node.val;

        if (l <= node.start && node.end <= r && node.isUniform)
            return node.val;

        return query(node.left, l, r) && query(node.right, l, r);
    }

    private static  void push(Node node) {
        if (node.start == node.end)
            return;

        int mid = node.start + (node.end - node.start) / 2;

        if (node.left == null)
            node.left = new Node(node.start, mid);

        if (node.right == null)
            node.right = new Node(mid + 1, node.end);

        if (node.isUniform) {
            node.left.val = node.val;
            node.right.val = node.val;

            node.left.isUniform = true;
            node.right.isUniform = true;

            node.isUniform = false;
        }
    }

    private static void pull(Node node) {
        if (node.left.isUniform && node.right.isUniform &&
                node.left.val == node.right.val) {

            node.isUniform = true;
            node.val = node.left.val;

            node.left = null;
            node.right = null;
        }
    }


}
class Node {
    int start, end;
    Node left, right;

    boolean val;        // true -> completely covered
    boolean isUniform;  // entire segment has same value

    Node(int s, int e) {
        start = s;
        end = e;
        val = false;
        isUniform = true;
    }
}
