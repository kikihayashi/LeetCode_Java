package LeetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/
 */

public class L501_E_FindModeinBinarySearchTree {

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


        int[] nums = new int[]{1, 2, 2, 2, 2, 3, 3, 4, 4, 4, 5, 5, 6, 6};

//        HashMap<Integer, Integer> map = new HashMap<>();
//        map.put(nums[0], 1);
//
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i - 1] == nums[i]) {
//                System.out.println(nums[i]);
//                map.put(nums[i - 1], map.get(nums[i - 1]) + 1);
//            } else {
//                map.put(nums[i - 1], map.get(nums[i - 1]) - 1);
//            }
//
//            if (map.get(nums[i - 1]) == 0) {
//                map.put(nums[i], 1);
//            }
//        }
//
//        System.out.println(map.size());


        TreeNode test = new TreeNode(1,
                null,
                new TreeNode(2, new TreeNode(2), null));//true

//        TreeNode test = new TreeNode(0, new TreeNode(-1), null);//true

//        TreeNode test = new TreeNode(3,
//                new TreeNode(1, new TreeNode(0), new TreeNode(2)),
//                new TreeNode(5, new TreeNode(4), new TreeNode(6)));//true

        System.out.println(Arrays.toString(findMode(test)));
    }

    /**
     * 僅適用於二元搜尋樹
     */
    public static int nowValue, count, maxCount;
    public static List<Integer> list;

    public static int[] findMode(TreeNode root) {
        count = 0;
        maxCount = 1;
        nowValue = Integer.MAX_VALUE;
        list = new LinkedList<>();
        /**
         * iterativeMethod
         */
//        iterativeMethod(root);

        /**
         * recursiveMethod
         */
        recursiveMethod(root);

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private static void iterativeMethod(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            if (currentNode != null) {
                if (currentNode.right != null) {
                    stack.add(currentNode.right);
                }
                stack.add(currentNode);
                stack.add(null);
                if (currentNode.left != null) {
                    stack.add(currentNode.left);
                }
            } else {
                TreeNode temp = stack.pop();
                if (nowValue != Integer.MAX_VALUE) {
                    nowValue = temp.val;
                    count++;
                } else {
                    if (temp.val == nowValue) {
                        count++;
                    } else {
                        nowValue = temp.val;
                        count = 1;
                    }
                }
                if (count > maxCount) {
                    maxCount = count;
                    list.clear();
                    list.add(nowValue);
                } else if (count == maxCount) {
                    list.add(nowValue);
                }
            }
        }
    }

    private static void recursiveMethod(TreeNode root) {
        if (root == null) {
            return;
        }
        recursiveMethod(root.left);
        if (nowValue == Integer.MAX_VALUE) {
            nowValue = root.val;
            count++;
        } else {
            if (root.val == nowValue) {
                count++;
            } else {
                nowValue = root.val;
                count = 1;
            }
        }
        if (count > maxCount) {
            maxCount = count;
            list.clear();
            list.add(nowValue);
        } else if (count == maxCount) {
            list.add(nowValue);
        }
        recursiveMethod(root.right);
    }

    /**
     * 適用於一般二元樹、二元搜尋樹
     */
    public static Map<Integer, Integer> map;
    public static int nowValue2;
    public static List<Integer> list2;

    public static int[] findMode2(TreeNode root) {
        nowValue2 = Integer.MAX_VALUE;
        list2 = new LinkedList<>();
        map = new HashMap<>();

        iterativeMethod2(root);

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int number = e.getValue();
            if (list2.isEmpty()) {
                list2.add(e.getKey());
            } else {
                if (number > map.get(list2.get(list2.size() - 1))) {
                    list2.clear();
                    list2.add(e.getKey());
                } else if (number == map.get(list2.get(list2.size() - 1))) {
                    list2.add(e.getKey());
                }
            }
        }

        int[] res = new int[list2.size()];
        for (int i = 0; i < list2.size(); i++) {
            res[i] = list2.get(i);
        }
        return res;
    }

    private static void iterativeMethod2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            if (currentNode != null) {
                if (currentNode.right != null) {
                    stack.add(currentNode.right);
                }
                stack.add(currentNode);
                stack.add(null);
                if (currentNode.left != null) {
                    stack.add(currentNode.left);
                }
            } else {
                TreeNode temp = stack.pop();
                if (map.isEmpty()) {
                    map.put(temp.val, 1);
                    nowValue2 = temp.val;
                } else {
                    if (nowValue2 != temp.val) {
                        map.put(temp.val, 1);
                        nowValue2 = temp.val;
                    } else {
                        map.put(nowValue2, map.get(nowValue2) + 1);
                    }
                }
            }
        }
    }
}
