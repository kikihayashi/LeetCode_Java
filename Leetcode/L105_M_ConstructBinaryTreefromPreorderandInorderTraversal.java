package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */

public class L105_M_ConstructBinaryTreefromPreorderandInorderTraversal {

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

        int[] test1 = new int[]{0, 1, 3, 6, 7, 4, 2, 5, 8, 9};
        int[] test2 = new int[]{6, 3, 7, 1, 4, 0, 2, 8, 5, 9};

//        int[] test1 = new int[]{3, 2, 1};
//        int[] test2 = new int[]{3, 2, 1};

//        int[] test1 = new int[]{1, 2, 3, 4};
//        int[] test2 = new int[]{3, 2, 4, 1};
        System.out.println(buildTree(test1, test2));
    }

    public static Map<Integer, Integer> mapIn, mapPre;
    public static int[] inOrder, preOrder;
    public static int indexPre;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        inOrder = inorder;
        preOrder = preorder;
        mapIn = new HashMap<>();
        mapPre = new HashMap<>();
        indexPre = 0;

        List<Integer> listIn = new ArrayList<>();
        List<Integer> listPre = new ArrayList<>();

        for (int i = 0; i < inorder.length; i++) {
            listIn.add(inorder[i]);
            listPre.add(preorder[i]);
            mapIn.put(inorder[i], i);
            mapPre.put(preorder[i], i);
        }

        TreeNode temp = recursiveMethod(0, preorder.length - 1);
//        TreeNode temp = recursiveMethod2(listPre, listIn);
        return temp;
    }

    private static TreeNode recursiveMethod2(List<Integer> listPre, List<Integer> listIn) {
        if (listIn.isEmpty()) {
            return null;
        }
        int valueMid = listPre.get(0);
        int indexIn = listIn.indexOf(valueMid);
        TreeNode leftNode = recursiveMethod2(listPre.subList(1, indexIn + 1), listIn.subList(0, indexIn));
        TreeNode rightNode = recursiveMethod2(listPre.subList(indexIn + 1, listIn.size()), listIn.subList(indexIn + 1, listIn.size()));
        return new TreeNode(valueMid, leftNode, rightNode);
    }

    //別人寫的
    private static TreeNode recursiveMethod(int left, int right) {
        if (left > right) {
            return null;
        }
        int valueMid = preOrder[indexPre++];
        int indexIn = mapIn.get(valueMid);
        TreeNode leftNode = recursiveMethod(left, indexIn - 1);
        TreeNode rightNode = recursiveMethod(indexIn + 1, right);
        return new TreeNode(valueMid, leftNode, rightNode);
    }
}
