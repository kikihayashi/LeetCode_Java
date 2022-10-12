package Leetcode;

import java.util.LinkedList;
import java.util.List;

public class L54_M_SpiralMatrix {

    /**
     * https://leetcode.com/problems/spiral-matrix/
     */

    public static void main(String[] args) {

//        int[][] test = new int[][]{{6}};
//        int[][] test = new int[][]{{6, 9, 7}};
//        int[][] test = new int[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}};
//        int[][] test = new int[][]{{6}, {9}, {7}};
//        int[][] test = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] test = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
//        int[][] test = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] test = new int[][]{{2, 3, 4}, {5, 6, 7}, {8, 9, 10}, {11, 12, 13}, {14, 15, 16}};

        System.out.println(spiralOrder(test));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int lengthH = matrix[0].length;
        int lengthV = matrix.length;
        int right = lengthH;
        int down = lengthV;
        List<Integer> list = new LinkedList<>();

        while (down > 0 && right > 0) {
            for (int j = lengthH - right; j < right - 1; j++) {
                list.add(matrix[lengthV - down][j]);
            }
            System.out.println(list);
            for (int j = lengthV - down; j < down - 1; j++) {
                list.add(matrix[j][right - 1]);
            }
            System.out.println(list);
            for (int j = right - 1; j > lengthV - down; j--) {
                list.add(matrix[down - 1][j]);
            }
            System.out.println(list);
            for (int j = down - 1; j > lengthH - right; j--) {
                list.add(matrix[j][lengthH - right]);
            }
            System.out.println(list);
            down--;
            right--;
            System.out.println("down:" + down);
            System.out.println("right:" + right);
        }
        if (list.size() < lengthH * lengthV) {
            list.add(matrix[lengthV / 2][lengthH / 2]);
        }
        if (list.size() > lengthH * lengthV) {
            int redundantLength = list.size() - lengthH * lengthV;
            while (redundantLength > 0) {
                list.remove(list.size() - 1);
                redundantLength--;
            }
        }
        return list;
    }
}
