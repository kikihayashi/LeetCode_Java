package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class L144_E_BinaryTreePreorderTraversal {

    /**
     * 中 -> 左 -> 右
     * https://leetcode.com/problems/binary-tree-preorder-traversal/
     */

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
//        TreeNode test = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), null);
//        TreeNode test = new TreeNode(4, new TreeNode(1, new TreeNode(2, new TreeNode(3),null), null), null);
//        TreeNode test = new TreeNode(1, null, new TreeNode(2,null, new TreeNode(3, null, new TreeNode(4))));
//        TreeNode test = new TreeNode(3, new TreeNode(2, null, new TreeNode(4, new TreeNode(1), null)), null);
//        TreeNode test = new TreeNode(1, new TreeNode(2, new TreeNode(4), null),
//                new TreeNode(3, new TreeNode(5), new TreeNode(6)));
        TreeNode test = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(4, new TreeNode(7), new TreeNode(8, new TreeNode(11), null))),
                new TreeNode(3,
                        new TreeNode(5, new TreeNode(9), null),
                        new TreeNode(6, new TreeNode(10), null)));

        System.out.println(preorderTraversal2(test));
        System.out.println(preorderTraversal(test));
    }

    /**
     * 遞迴、跌代統一寫法-----------------------------------------------------------------
     */

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        /**
         *  iterativeMethod
         */
        return iterativeTemplate(root);

        /**
         *  recursiveMethod
         */
//        recursiveTemplate(root, list);
//        return list;
    }

    //跌代統一寫法
    private static List<Integer> iterativeTemplate(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            if (currentNode != null) {
                if (currentNode.right != null) {
                    stack.push(currentNode.right);
                }
                if (currentNode.left != null) {
                    stack.push(currentNode.left);
                }
                stack.push(currentNode);
                stack.push(null);//標記(固定放在中間節點後面)
            } else {
                list.add(stack.pop().val);
            }
        }
        return list;
    }

    //遞迴統一寫法
    private static void recursiveTemplate(TreeNode currentRoot, List<Integer> list) {
        if (currentRoot == null) {
            return;
        }
        list.add(currentRoot.val);
        recursiveTemplate(currentRoot.left, list);
        recursiveTemplate(currentRoot.right, list);
    }

    /**
     * 遞迴、跌代統一寫法-----------------------------------------------------------------
     */

    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        /**
         *  iterativeMethod
         */
        return iterativeMethod(root);

        /**
         *  recursiveMethod
         */
//        Stack<TreeNode> stack = new Stack<>();
//        stack.add(root);
//        list.add(root.val);
//        return recursiveMethod(root.left, stack, list);
    }

    private static List<Integer> iterativeMethod(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        stack.add(root);
        list.add(root.val);
        TreeNode currentNode = root.left;

        while (true) {
            if (stack.size() == 0 && currentNode == null) {
                break;
            }
            if (currentNode != null) {
                list.add(currentNode.val);
                stack.add(currentNode);
                currentNode = currentNode.left;
            } else {
                TreeNode tempNode = stack.pop();
                currentNode = tempNode.right;
            }
        }
        return list;
    }

    private static List<Integer> recursiveMethod(TreeNode currentRoot, Stack<TreeNode> stack, List<Integer> list) {
        if (currentRoot == null) {
            if (stack.size() == 0) {
                return list;
            }
            currentRoot = stack.pop().right;
            return recursiveMethod(currentRoot, stack, list);
        } else {
            list.add(currentRoot.val);
            stack.add(currentRoot);
            return recursiveMethod(currentRoot.left, stack, list);
        }
    }
}
