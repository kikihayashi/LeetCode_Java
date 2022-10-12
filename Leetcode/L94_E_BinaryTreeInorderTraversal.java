package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class L94_E_BinaryTreeInorderTraversal {

    /**
     * 左 -> 中 -> 右
     * https://leetcode.com/problems/binary-tree-inorder-traversal/
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

        System.out.println(inorderTraversal(test));
        System.out.println(inorderTraversal2(test));
    }

    /**
     * 遞迴、跌代統一寫法-----------------------------------------------------------------
     */

    public static List<Integer> inorderTraversal(TreeNode root) {
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
                stack.push(currentNode);
                stack.push(null);//標記(固定放在中間節點後面)
                if (currentNode.left != null) {
                    stack.push(currentNode.left);
                }
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
        recursiveTemplate(currentRoot.left, list);
        list.add(currentRoot.val);
        recursiveTemplate(currentRoot.right, list);
    }

    /**
     * 遞迴、跌代統一寫法-----------------------------------------------------------------
     */

    public static List<Integer> inorderTraversal2(TreeNode root) {
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
//         Stack<TreeNode> stack = new Stack<>();
//         stack.add(root);
//         return recursiveMethod(root.left, stack, list);
    }

    //自己寫新的
    private static List<Integer> iterativeMethod(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        stack.add(root);
        TreeNode currentNode = root.left;

        while (true) {
            if (stack.size() == 0 && currentNode == null) {
                break;
            }
            if (currentNode != null) {
                stack.add(currentNode);
                currentNode = currentNode.left;
            } else {
                TreeNode tempNode = stack.pop();
                list.add(tempNode.val);
                currentNode = tempNode.right;
            }
        }
        return list;
    }

    //自己寫舊的
    private static List<Integer> iterativeMethod2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        //主Stack(不會有null值)
        Stack<TreeNode> mainStack = new Stack<>();
        //暫存Stack(可能有null值)
        Stack<TreeNode> tempStack = new Stack<>();
        TreeNode tempRoot;

        //先將root(父結點)放入暫存Stack
        tempStack.add(root);

        while (true) {
            //當兩個Stack都沒有東西時結束迴圈
            if (tempStack.size() + mainStack.size() == 0) {
                break;
            }
            //把暫存Stack裡面的tempRoot拿出來
            tempRoot = tempStack.pop();
            //如果tempRoot是空值，或左右結點都是空值時，將最上面的root取出放入list裡
            if (tempRoot == null || (tempRoot.left == null && tempRoot.right == null)) {
                //如果tempRoot不是空值，將此tempRoot放入list裡
                if (tempRoot != null) {
                    list.add(tempRoot.val);
                }
                //如果主Stack有東西時，將最上面的root取出放入list裡
                if (mainStack.size() > 0) {
                    list.add(mainStack.pop().val);
                }
                continue;
            }
            //並非以上情況時，將tempRoot的右結點先存入暫存Stack，再存左結點
            tempStack.add(tempRoot.right);
            tempStack.add(tempRoot.left);
            //tempRoot自己本身存入主Stack
            mainStack.add(tempRoot);
        }
        return list;
    }

    private static List<Integer> recursiveMethod(TreeNode currentRoot, Stack<TreeNode> stack, List<Integer> list) {
        //如果當前root為空值
        if (currentRoot == null) {
            //檢查stack是否有東西，如果沒有就回傳list
            if (stack.size() == 0) {
                return list;
            }
            //如果stack有東西，令當前root = stack最上面的root的右節點
            currentRoot = stack.pop().right;
            //將stack最上面的root取出並存入list
            list.add(currentRoot.val);
            //遞迴處理
            return recursiveMethod(currentRoot, stack, list);
        }
        //如果當前root有值
        else {
            //將當前root存入stack
            stack.add(currentRoot);
            //將當前root=當前root的左節點，再遞迴處理
            return recursiveMethod(currentRoot.left, stack, list);
        }
    }

}
