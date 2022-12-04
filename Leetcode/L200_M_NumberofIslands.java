package Leetcode;

public class L200_M_NumberofIslands {

    /**
     * https://leetcode.com/problems/number-of-islands/?envType=study-plan&id=level-1
     */

    public static void main(String[] args) {

        char[][] test = new char[][]{
                new char[]{'1', '1', '0', '0', '1'},
                new char[]{'1', '1', '0', '1', '0'},
                new char[]{'0', '1', '1', '1', '1'},
                new char[]{'0', '0', '0', '1', '0'}};

        System.out.println(numIslands(test));
        printImages(setArray);
    }

    private static int[][] setArray;

    public static int numIslands(char[][] grid) {
        int number = 0;
        setArray = new int[grid.length][grid[0].length];
        
        recursiveM(0, 0, grid.length, grid[0].length, grid);
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                if (grid[i][j] == '1' && setArray[i][j] == 0) {
//                    number++;
//                    recursiveM(i, j, grid.length, grid[i].length, grid);
//                }
//            }
//        }
        return number;
    }

    private static void recursiveM(int i, int j, int i_max, int j_max, char[][] grid) {
        if (0 <= i && i < i_max && 0 <= j && j < j_max && grid[i][j] == '1' && setArray[i][j] == 0) {
            setArray[i][j]++;
            recursiveM(i, j - 1, grid.length, grid[i].length, grid);
            recursiveM(i, j + 1, grid.length, grid[i].length, grid);
            recursiveM(i - 1, j, grid.length, grid[i].length, grid);
            recursiveM(i + 1, j, grid.length, grid[i].length, grid);
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
