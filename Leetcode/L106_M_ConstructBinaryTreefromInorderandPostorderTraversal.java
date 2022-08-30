package Leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */

public class L106_M_ConstructBinaryTreefromInorderandPostorderTraversal {

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

//        int[] test1 = new int[]{9, 3, 15, 20, 7};
//        int[] test2 = new int[]{9, 15, 7, 20, 3};
//        int[] test1 = new int[]{2, 1};
//        int[] test2 = new int[]{2, 1};

//        int[] test1 = new int[]{1, 2};
//        int[] test2 = new int[]{2, 1};

//        int[] test1 = new int[]{6, 3, 7, 1, 4, 0, 2, 8, 5, 9};
//        int[] test2 = new int[]{6, 7, 3, 4, 1, 8, 9, 5, 2, 0};

//        int[] test1 = new int[]{3, 2, 1};
//        int[] test2 = new int[]{3, 2, 1};

        int[] test1 = new int[]{1, 2, 3, 4};
        int[] test2 = new int[]{3, 2, 4, 1};
        System.out.println(buildTree(test1, test2));
    }

    public static Map<Integer, Integer> mapIn, mapPo;
    public static int[] inOrder, postOrder;
    public static int indexPo;

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        inOrder = inorder;
        postOrder = postorder;
        mapIn = new HashMap<>();
        mapPo = new HashMap<>();
        indexPo = postorder.length - 1;

        List<Integer> listIn = new ArrayList<>();
        List<Integer> listPo = new ArrayList<>();

        for (int i = 0; i < inorder.length; i++) {
            listIn.add(inorder[i]);
            listPo.add(postorder[i]);
            mapIn.put(inorder[i], i);
            mapPo.put(postorder[i], i);
        }

        /**
         *  recursiveMethod
         */
//        TreeNode temp = recursiveMethod(0, postorder.length - 1);
        TreeNode temp = recursiveMethod2(listIn, listPo);
        return temp;
    }

    private static TreeNode recursiveMethod2(List<Integer> listIn, List<Integer> listPo) {
        if (listIn.isEmpty()) {
            return null;
        }
        int valueMid = listPo.get(listPo.size() - 1);
        int indexIn = listIn.indexOf(valueMid);
        TreeNode leftNode = recursiveMethod2(listIn.subList(0, indexIn), listPo.subList(0, indexIn));
        TreeNode rightNode = recursiveMethod2(listIn.subList(indexIn + 1, listIn.size()), listPo.subList(indexIn, listIn.size() - 1));
        return new TreeNode(valueMid, leftNode, rightNode);
    }

    //別人寫的
    private static TreeNode recursiveMethod(int left, int right) {
        if (left > right) {
            return null;
        }
        int valueMid = postOrder[indexPo--];
        int indexIn = mapIn.get(valueMid);
        TreeNode leftNode = recursiveMethod(left, indexIn - 1);
        TreeNode rightNode = recursiveMethod(indexIn + 1, right);
        return new TreeNode(valueMid, leftNode, rightNode);
    }
}
