package Leetcode;

import java.util.Arrays;

public class L733_E_FloodFill {

    /**
     * https://leetcode.com/problems/flood-fill/?envType=study-plan&id=level-1
     */

    public static void main(String[] args) {

        int[][] images = new int[][]{new int[]{1, 1, 1}, new int[]{1, 1, 0}, new int[]{1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int color = 2;
//        int[][] images = new int[][]{new int[]{0, 0, 0}, new int[]{0, 0, 0}};
//        int sr = 0;
//        int sc = 0;
//        int color = 0;

        printImages(images);
        int[][] ans = floodFill(images, sr, sc, color);
        printImages(ans);
    }

    public static int[][] floodFill(int[][] images, int sr, int sc, int color) {
        if (images[sr][sc] == color) {
            return images;
        }
        recursiveM(images[sr][sc], images, sr, sc, color);
        return images;
    }

    private static void recursiveM(int initValue, int[][] images, int sr, int sc, int color) {
        if (sr >= 0 && sr < images.length && sc >= 0 && sc < images[0].length && images[sr][sc] == initValue) {
            images[sr][sc] = color;
            recursiveM(initValue, images, sr, sc - 1, color);
            recursiveM(initValue, images, sr, sc + 1, color);
            recursiveM(initValue, images, sr - 1, sc, color);
            recursiveM(initValue, images, sr + 1, sc, color);
        } else {
            return;
        }
    }

    private static void printImages(int[][] ans) {
        System.out.println("------------------");
        for (int[] r : ans) {
            for (int c : r) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println("------------------");
    }
}
