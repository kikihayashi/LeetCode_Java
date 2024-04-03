package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L59_M_SpiralMatrixII {

    /**
     * https://leetcode.com/problems/spiral-matrix-ii/
     */

    public static void main(String[] args) {

//        int[][] test = new int[][]{{6}};
//        int[][] test = new int[][]{{6, 9, 7}};
//        int[][] test = new int[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}};
//        int[][] test = new int[][]{{6}, {9}, {7}};
//        int[][] test = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] test = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
//        int[][] test = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
//        int[][] test = new int[][]{{2, 3, 4}, {5, 6, 7}, {8, 9, 10}, {11, 12, 13}, {14, 15, 16}};

        int test = 4;
        System.out.println(Arrays.deepToString(generateMatrix(test)));
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int value = 1;
        int lengthH = n;
        int lengthV = n;
        int right = lengthH;
        int down = lengthV;

        while (down > 0 && right > 0) {
            for (int j = lengthH - right; j < right - 1; j++) {
                matrix[lengthV - down][j] = value++;
            }
            System.out.println(Arrays.deepToString(matrix));
            for (int j = lengthV - down; j < down - 1; j++) {
                matrix[j][right - 1] = value++;
            }
            System.out.println(Arrays.deepToString(matrix));
            for (int j = right - 1; j > lengthV - down; j--) {
                matrix[down - 1][j] = value++;
            }
            System.out.println(Arrays.deepToString(matrix));
            for (int j = down - 1; j > lengthH - right; j--) {
                matrix[j][lengthH - right] = value++;
            }
            System.out.println(Arrays.deepToString(matrix));
            down--;
            right--;
        }
        if (n % 2 == 1) {
            matrix[n / 2][n / 2] = n * n;
        }
        return matrix;
    }
}
