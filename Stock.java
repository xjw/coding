/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/

/**
 * What's not very clear is whether you can buy and sell the same day (apparently yes)
 * so at least the profit should be >=0
 */ 

public class Stock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int min = prices[0];
        int max_diff = 0;

        for (int i=1; i<prices.length; i++) {
            int curr = prices[i];
            int curr_diff = curr - min;
            if (curr_diff > max_diff) {
                max_diff = curr_diff;
            }
            if (curr < min) min = curr;
        }
        return max_diff;
    }
}
