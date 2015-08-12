/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

/**
 * best strategy is to sell whenever there is profit and buy again
 */ 

public class StockII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int min = prices[0];
        int profit = 0;
        for (int i=1; i<prices.length; i++) {
            int curr = prices[i];
            if (curr > min) profit += curr - min;
            min = curr;
        }
        return profit;
    }
}
