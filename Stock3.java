/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.
*/

/**
 * DP: split into left and right, there are n ways of spliting
 */ 

public class Stock3 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int len = prices.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int min = prices[0];
        int max = prices[len-1];
        int curr = 0;

        int maxP = 0;
        for (int i=1; i<len; i++) {
            curr = prices[i];
            maxP = Math.max(curr - min, maxP);
            left[i] = maxP;
            min = Math.min(curr, min);
        }

        maxP = 0;
        for (int i=len-2; i>=0; i--) {
            curr = prices[i];
            maxP = Math.max(max - curr, maxP);
            right[i]  = maxP;
            max = Math.max(max, curr);
        }

        maxP = 0;
        for (int i=0; i<len; i++) {
            maxP = Math.max(maxP, left[i] + right[i]);
        }
        return maxP;
    }

    public void test() {
        int[] prices = {2,1,2,0,1};
        System.out.println(maxProfit(prices));
    }

    public static void main(String[] args) {
        new Stock3().test();
    }
}
