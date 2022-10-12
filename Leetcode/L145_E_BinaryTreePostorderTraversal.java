package Leetcode;

import java.util.*;

public class L145_E_BinaryTreePostorderTraversal {

    /**
     * 左 -> 右 -> 中
     * https://leetcode.com/problems/binary-tree-postorder-traversal/
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


        System.out.println(postorderTraversal(test));
        System.out.println(postorderTraversal2(test));
    }

    /**
     * 遞迴、跌代統一寫法-----------------------------------------------------------------
     */

    public static List<Integer> postorderTraversal(TreeNode root) {
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
    private static void recursiveTemplate(TreeNode currentRoot, List<Integer> list) {
        if (currentRoot == null) {
            return;
        }
        recursiveTemplate(currentRoot.left, list);
        recursiveTemplate(currentRoot.right, list);
        list.add(currentRoot.val);
    }

    //遞迴統一寫法
    private static List<Integer> iterativeTemplate(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            if (currentNode != null) {
                stack.push(currentNode);
                stack.push(null);//標記(固定放在中間節點後面)
                if (currentNode.right != null) {
                    stack.push(currentNode.right);
                }
                if (currentNode.left != null) {
                    stack.push(currentNode.left);
                }
            } else {
                list.add(stack.pop().val);
            }
        }
        return list;
    }

    /**
     * 遞迴、跌代統一寫法-----------------------------------------------------------------
     */

    public static List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
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
//        return recursiveMethod(stack, list);
    }

    //別人寫的0 ms、37.2 MB
    private static List<Integer> iterativeMethod(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            list.addFirst(currentNode.val);
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
        }
        return list;
    }

    //自己的：1 ms、37.2 MB
    private static List<Integer> iterativeMethod2(TreeNode root) {
        Map<TreeNode, Boolean> map = new HashMap<>();
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode currentNode = root;

        while (stack.size() > 0) {
            if (map.get(currentNode) != null) {
                list.add(stack.pop().val);
                if (stack.size() > 0) {
                    currentNode = stack.peek();
                }
            } else {
                map.put(currentNode, true);
                if (currentNode.left != null && currentNode.right != null) {
                    stack.add(currentNode.right);
                    stack.add(currentNode.left);
                    currentNode = currentNode.left;
                } else if (currentNode.left != null && currentNode.right == null) {
                    stack.add(currentNode.left);
                    currentNode = currentNode.left;
                } else if (currentNode.right != null && currentNode.left == null) {
                    stack.add(currentNode.right);
                    currentNode = currentNode.right;
                }
            }
        }
        return list;
    }

    //別人寫的0 ms、37.5 MB
    private static List<Integer> recursiveMethod(Stack<TreeNode> stack, LinkedList<Integer> list) {
        if (stack.isEmpty()) {
            return list;
        }
        TreeNode currentNode = stack.pop();
        list.addFirst(currentNode.val);
        if (currentNode.left != null) {
            stack.push(currentNode.left);
        }
        if (currentNode.right != null) {
            stack.push(currentNode.right);
        }
        return recursiveMethod(stack, list);
    }
}



