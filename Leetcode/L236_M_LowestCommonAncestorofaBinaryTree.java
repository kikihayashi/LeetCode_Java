package Leetcode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */

public class L236_M_LowestCommonAncestorofaBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        TreeNode node0 = new TreeNode(3);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);

        node0.left = node1;
        node0.right = node2;

        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);

        node1.left = node3;
        node1.right = node4;

        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(8);

        node2.left = node5;
        node2.right = node6;

        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(4);

        node4.left = node7;
        node4.right = node8;

        System.out.println(lowestCommonAncestor(node0, node1, node8).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = recursiveMethod(root, p, q);
        return ans;
    }

    private static TreeNode recursiveMethod(TreeNode root, TreeNode p, TreeNode q) {
        if (p == q) {
            return p;
        }
        //如果p裡面可以找到q
        if (getSubRoot(p, q) != null) {
            return p;
        }
        //如果q裡面可以找到p
        if (getSubRoot(q, p) != null) {
            return q;
        }
        //如果根節點等於p或q
        if (root == p || root == q) {
            return root;
        }
        //找p的根結點
        TreeNode subNodeP = getSubRoot(root, p);
        //找q的根結點
        TreeNode subNodeQ = getSubRoot(root, q);
        //將p、q的根結點遞迴代入再找一次
        return recursiveMethod(root, subNodeP, subNodeQ);
    }

    //找subRoot上面的根結點(初始放入的root裡面一定有subRoot)
    private static TreeNode getSubRoot(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return null;
        }
        if (root.left == subRoot || root.right == subRoot) {
            return root;
        }
        TreeNode leftNode = getSubRoot(root.left, subRoot);
        TreeNode rightNode = getSubRoot(root.right, subRoot);
        if (leftNode != null && rightNode == null) {
            return leftNode;
        } else if (rightNode != null && leftNode == null) {
            return rightNode;
        } else {
            return null;
        }
    }
}
