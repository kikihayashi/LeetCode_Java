package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 */

public class L671_E_SecondMinimumNodeInaBinaryTree {

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
//
//        TreeNode test = new TreeNode(1,
//                new TreeNode(1,
//                        new TreeNode(1,
//                                new TreeNode(3, new TreeNode(3), new TreeNode(3)),
//                                new TreeNode(1, new TreeNode(1), new TreeNode(6))),
//                        new TreeNode(1,
//                                new TreeNode(1, new TreeNode(2), new TreeNode(1)),
//                                new TreeNode(1))),
//                new TreeNode(3,
//                        new TreeNode(3,
//                                new TreeNode(3),
//                                new TreeNode(8)),
//                        new TreeNode(4,
//                                new TreeNode(4),
//                                new TreeNode(8))));

//        TreeNode test = new TreeNode(8);

        TreeNode test = new TreeNode(1,
                new TreeNode(1, new TreeNode(1), new TreeNode(5)),
                new TreeNode(1, new TreeNode(1), new TreeNode(4)));

//        TreeNode test = new TreeNode(2,
//                new TreeNode(2),
//                new TreeNode(5, new TreeNode(5), new TreeNode(7)));

//        TreeNode test = new TreeNode(2, new TreeNode(2), new TreeNode(2));

//        TreeNode test = new TreeNode(5, new TreeNode(5), new TreeNode(6));

        System.out.println("ans:" + findSecondMinimumValue(test));
    }

    private static int firstMin;
    private static int secondMin;
    private static List<Integer> list;

    public static int findSecondMinimumValue(TreeNode root) {
        firstMin = -1;
        secondMin = -1;
        list = new LinkedList<>();
        /**
         *  recursiveMethod
         */
        recursiveMethod(root);
        System.out.println(list);
        return (firstMin == secondMin) ? -1 : secondMin;
    }

    private static void recursiveMethod(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.right != null) {
            int min = Math.min(root.left.val, root.right.val);
            int max = Math.max(root.left.val, root.right.val);
            if (firstMin < 0) {
                firstMin = min;
                secondMin = max;
            } else {
                if (firstMin == secondMin) {
                    secondMin = max;
                } else {
                    if (firstMin < max && max < secondMin) {
                        secondMin = max;
                    }
                }
            }
            list.add(max);
        }
        recursiveMethod(root.left);
        recursiveMethod(root.right);
    }


}
