package Leetcode;

public class L62_M_UniquePaths {

    /**
     * https://leetcode.com/problems/unique-paths/?envType=study-plan&id=level-1
     */

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println(uniquePaths(m, n));//28
    }

    private static int[][] map;

    public static int uniquePaths(int m, int n) {
        map = new int[m][n];
        return recursiveM(m, n);
    }

    private static int recursiveM(int m, int n) {
        if (map[m - 1][n - 1] > 0) {
            return map[m - 1][n - 1];
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        if (m == 2 && n == 2) {
            return 2;
        }
        map[m - 1][n - 1] = recursiveM(m, n - 1) + recursiveM(m - 1, n);
        return map[m - 1][n - 1];
    }
}
