package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class L101_E_SymmetricTree {

    /**
     * https://leetcode.com/problems/symmetric-tree/
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
//        TreeNode test = new TreeNode(1, new TreeNode(2, null, new TreeNode(4,
//                new TreeNode(7), new TreeNode(8, new TreeNode(11), null))), new TreeNode(3, new TreeNode(5,
//                new TreeNode(9), null), new TreeNode(6, null, new TreeNode(10))));

//        TreeNode test = new TreeNode(1,
//                new TreeNode(2, null, new TreeNode(7)),
//                new TreeNode(2, new TreeNode(7), null));

        TreeNode test = new TreeNode(1,new TreeNode(2,null, new TreeNode(3)),
                new TreeNode(2,null, new TreeNode(3)));

        System.out.println(isSymmetric(test));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        /**
         *  iterativeMethod
         */
//        return iterativeMethod(root);

        /**
         *  recursiveMethod
         */
        return recursiveMethod(root.left, root.right);
    }

    public static boolean recursiveMethod(TreeNode leftRoot, TreeNode rightRoot) {
        //如果左右節點都是空，回傳true
        if (leftRoot == null && rightRoot == null) {
            return true;
        }
        //如果左右節點不為空，且左右節點相同，將左節點的左方與右節點的右方遞迴帶入計算、左節點的右方與右節點的左方遞迴帶入計算。
        if ((leftRoot != null && rightRoot != null) && (leftRoot.val == rightRoot.val)) {
            return recursiveMethod(leftRoot.left, rightRoot.right) &&
                    recursiveMethod(leftRoot.right, rightRoot.left);
        }
        //其他情況回傳false
        else {
            return false;
        }
    }

    public static boolean iterativeMethod(TreeNode root) {
        //建立負責儲存對稱左方的Queue，與右方的Queue
        Queue<TreeNode> leftQ = new LinkedList<>();
        Queue<TreeNode> rightQ = new LinkedList<>();
        //第一次先填入根的左右節點
        leftQ.add(root.left);
        rightQ.add(root.right);

        //如果左右Queue的長度大於0，就繼續執行迴圈
        while (leftQ.size() + rightQ.size() > 0) {
            //取出左右Queue的第一個節點
            TreeNode leftRoot = leftQ.poll();
            TreeNode rightRoot = rightQ.poll();
            //如果左右節點不為空，且左右節點相同
            if ((leftRoot != null && rightRoot != null) && (leftRoot.val == rightRoot.val)) {
                //如果左節點的左方與右節點的右方，其中一個不為空，就存到左右Queue
                if (leftRoot.left != null || rightRoot.right != null) {
                    leftQ.add(leftRoot.left);
                    rightQ.add(rightRoot.right);
                }
                //如果左節點的右方與右節點的左方，其中一個不為空，就存到左右Queue
                if (leftRoot.right != null || rightRoot.left != null) {
                    leftQ.add(leftRoot.right);
                    rightQ.add(rightRoot.left);
                }
            }
            //其他情況回傳false
            else {
                return false;
            }
        }
        return true;
    }

    public static boolean isSymmetric2(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        Queue<TreeNode> leftQ = new LinkedList<>();
        Queue<TreeNode> rightQ = new LinkedList<>();
        leftQ.add(root.left);
        rightQ.add(root.right);

        while (leftQ.size() + rightQ.size() > 0) {
            if (leftQ.element() == null && rightQ.element() == null) {
                leftQ.poll();
                rightQ.poll();
            } else if (leftQ.element() != null && rightQ.element() != null) {
                if (checkNodeSymmetric(leftQ.element(), rightQ.element())) {
                    leftQ = setQueue(leftQ.element().left, leftQ.element().right, leftQ);
                    rightQ = setQueue(rightQ.element().right, rightQ.element().left, rightQ);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean checkNodeSymmetric(TreeNode leftRoot, TreeNode rightRoot) {
        boolean r1 = leftRoot.val == rightRoot.val;
        boolean r2 = (leftRoot.left.val == rightRoot.right.val);
        boolean r3 = leftRoot.right.val == rightRoot.left.val;
        return r1 && r2 && r3;
    }

    private static Queue<TreeNode> setQueue(TreeNode firstAddRoot, TreeNode lastAddRoot, Queue<TreeNode> queue) {
        queue.poll();
        queue.add(firstAddRoot);
        queue.add(lastAddRoot);
        return queue;
    }


    private static Queue<TreeNode> setQueue(TreeNode root, Queue<TreeNode> queue, Direction dir) {
        if (root.left == null && root.right == null) {
            return queue;
        } else {
            switch (dir) {
                case Left:
                    queue.add(root.left);
                    queue.add(root.right);
                    break;

                case Right:
                    queue.add(root.right);
                    queue.add(root.left);
                    break;
            }
        }
        return queue;
    }

    enum Direction {
        Right, Left;
    }
}
