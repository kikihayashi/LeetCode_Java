package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/distribute-coins-in-binary-tree/
 */

public class L979_M_DistributeCoinsinBinaryTree {

    public L144_E_BinaryTreePreorderTraversal test144 = new L144_E_BinaryTreePreorderTraversal();

    static class TreeNode {
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

//        TreeNode test = new TreeNode(8);

        TreeNode test0 = new TreeNode(4,
                new TreeNode(0, new TreeNode(0), new TreeNode(0)),
                new TreeNode(0, new TreeNode(1), new TreeNode(2)));
//
//        TreeNode test = new TreeNode(1,
//                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
//                null);

        TreeNode test3 = new TreeNode(3, new TreeNode(0), new TreeNode(0));

        TreeNode test4 = new TreeNode(0, new TreeNode(3), new TreeNode(0));

        TreeNode test = new TreeNode(3,
                new TreeNode(2, new TreeNode(0), new TreeNode(0, null, new TreeNode(0))),
                null);

        TreeNode test2 = new TreeNode(0,
                new TreeNode(0),
                new TreeNode(2, new TreeNode(3), new TreeNode(0)));


//        TreeNode test = new TreeNode(-8,
//                new TreeNode(3, new TreeNode(-8, null, new TreeNode(-1, null, new TreeNode(8))), null),
//                new TreeNode(0));


        System.out.println("ans:" + distributeCoins(test4));
    }

    private static int move;

    public static int distributeCoins(TreeNode root) {
        move = 0;

        /**
         *  recursiveMethod
         */
        recursiveMethod(root);
        return move;
    }

    private static int recursiveMethod(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recursiveMethod(root.left);
        move += Math.abs(left);
        int right = recursiveMethod(root.right);
        move += Math.abs(right);
        return left + right + root.val - 1;
    }

    /**
     * 別人寫的
     */

    private static int ans = 0;

    public static int distributeCoins2(TreeNode root) {
        // 對於每個點來說，他需要分配出去的印幣，就是node.val - 1
        // 因此我們只要統計，每個點需要分配多少出去即可
        dfs(root);
        return ans;
    }

    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        // 目前兒子給我的數量 + 我自己的數量
        int sum = left + right + root.val;
        // 所以我的移動數量 就是 sum - 1 （留下一顆）
        ans += Math.abs(sum - 1);
        // 然後把我的數量給我的parent
        return sum - 1;
    }
}
