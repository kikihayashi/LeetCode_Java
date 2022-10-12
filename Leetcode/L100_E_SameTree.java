package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class L100_E_SameTree {

    /**
     * https://leetcode.com/problems/same-tree/
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

        TreeNode test = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(3)));

        System.out.println(isSameTree(test, test));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        /**
         *  iterativeMethod
         */
        return iterativeMethod(p, q);

        /**
         *  recursiveMethod
         */
//        return recursiveMethod(p, q);
    }

    public static boolean recursiveMethod(TreeNode leftRoot, TreeNode rightRoot) {
        //如果左右節點都是空，回傳true
        if (leftRoot == null && rightRoot == null) {
            return true;
        }
        //如果左右節點不為空，且左右節點相同，將左節點的左方與右節點的左方遞迴帶入計算、左節點的右方與右節點的右方遞迴帶入計算。
        if ((leftRoot != null && rightRoot != null) && (leftRoot.val == rightRoot.val)) {
            return recursiveMethod(leftRoot.left, rightRoot.left) &&
                    recursiveMethod(leftRoot.right, rightRoot.right);
        }
        //其他情況回傳false
        else {
            return false;
        }
    }

    public static boolean iterativeMethod(TreeNode leftRoot, TreeNode rightRoot) {
        //建立負責儲存對稱左方的Queue，與右方的Queue
        Queue<TreeNode> leftQ = new LinkedList<>();
        Queue<TreeNode> rightQ = new LinkedList<>();
        //第一次先填入根的左右節點
        leftQ.add(leftRoot);
        rightQ.add(rightRoot);

        //如果左右Queue的長度大於0，就繼續執行迴圈
        while (leftQ.size() + rightQ.size() > 0) {
            //取出左右Queue的第一個節點
            TreeNode currentLeftRoot = leftQ.poll();
            TreeNode currentRightRoot = rightQ.poll();
            //如果左右節點不為空，且左右節點相同
            if ((currentLeftRoot != null && currentRightRoot != null) && (currentLeftRoot.val == currentRightRoot.val)) {
                //如果左節點的左方與右節點的左方，其中一個不為空，就存到左右Queue
                if (currentLeftRoot.left != null || currentRightRoot.left != null) {
                    leftQ.add(currentLeftRoot.left);
                    rightQ.add(currentRightRoot.left);
                }
                //如果左節點的右方與右節點的右方，其中一個不為空，就存到左右Queue
                if (currentLeftRoot.right != null || currentRightRoot.right != null) {
                    leftQ.add(currentLeftRoot.right);
                    rightQ.add(currentRightRoot.right);
                }
            }
            //其他情況回傳false
            else {
                return false;
            }
        }
        return true;
    }
}
