package LeetCode;

public class L121_E_BestTimetoBuyandSellStock {
    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
     */

    public static void main(String[] args) {


//        int[] test = new int[]{7, 1, 5, 3, 6, 4};
        int[] test = new int[]{1, 2};
//        int[] test = new int[]{7, 6, 4, 3, 1};

        System.out.println(maxProfit2(test));
    }

    public static int maxProfit2(int[] prices) {
        int profit = 0;
        int buy = prices[0];

        for (int sellDay = 1; sellDay < prices.length; sellDay++) {
            if (prices[sellDay] < buy) {
                buy = prices[sellDay];
            } else {
                profit =  Math.max(profit, prices[sellDay] - buy);
            }
        }
        return profit;
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int sell = prices[prices.length - 1];

        for (int buyDay = prices.length - 2; buyDay >= 0; buyDay--) {
            if (sell - prices[buyDay] < 0) {
                sell = prices[buyDay];
            } else {
                profit = Math.max(profit, sell - prices[buyDay]);
            }
        }
        return profit;
    }


}
