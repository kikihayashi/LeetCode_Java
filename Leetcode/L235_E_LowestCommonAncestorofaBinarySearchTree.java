package Leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */

public class L235_E_LowestCommonAncestorofaBinarySearchTree {

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

        TreeNode node0 = new TreeNode(6);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(8);

        node0.left = node1;
        node0.right = node2;

        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);

        node1.left = node3;
        node1.right = node4;

        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);

        node2.left = node5;
        node2.right = node6;

        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(5);

        node4.left = node7;
        node4.right = node8;

        System.out.println(lowestCommonAncestor(node0, node3, node8).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return recursiveM(root, p, q);
    }

    private static TreeNode recursiveM(TreeNode root, TreeNode p, TreeNode q) {


        TreeNode subRoot = getSubRoot1(root, p);
        return null;

    }

    private static TreeNode getSubRoot1(TreeNode root, TreeNode subRoot) {
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            if (currentNode.left != null) {
                if (currentNode.left == subRoot) {
                    return currentNode;
                }
                stack.push(currentNode.left);
            }
            if (currentNode.right != null) {
                if (currentNode.right == subRoot) {
                    return currentNode;
                }
                stack.push(currentNode.right);
            }
        }
        return root;
    }

    //p < q
    //初始代入p一定小於q
    private static TreeNode recursiveMethod(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val > p.val && root.val > q.val) {
            return recursiveMethod(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return recursiveMethod(root.right, p, q);
        } else {
            return root;
        }
    }

    private static TreeNode recursiveMethod3(TreeNode root, TreeNode p, TreeNode q) {
        if (p == root || q == root || root == null) {
            return root;
        }
        TreeNode left = recursiveMethod3(root.left, p, q);
        TreeNode right = recursiveMethod3(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null && right == null) {
            return left;
        } else if (left == null && right != null) {
            return right;
        } else {
            return null;
        }

    }

    private static TreeNode recursiveMethod2(TreeNode root, TreeNode p, TreeNode q) {
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
        return recursiveMethod2(root, subNodeP, subNodeQ);
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
