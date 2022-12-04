package Leetcode;

public class L742_E_MinCostClimbingStairs {

    /**
     * https://leetcode.com/problems/min-cost-climbing-stairs/?envType=study-plan&id=level-1
     */

    public static void main(String[] args) {

        int[] test = new int[]{10, 15, 20};
        int[] test2 = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] test3 = new int[]{0, 1, 2, 2};
        int[] test4 = new int[]{0, 2, 1, 2};
        System.out.println(minCostClimbingStairs(test));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 2];
        for (int i = cost.length - 1; i >= 0; i--) {
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }
        return Math.min(dp[0],dp[1]);
    }
}
