class Solution {
    public int maxProfit(int[] prices, int fee) {
        int hold = -prices[0]; // either bought stock on ith day or carry forward existing holded stock
        int sell = 0; // either sell stock on ith day or carry forward without any stock
        for (int i = 1; i < prices.length; i++) {
            int holdi = Math.max(hold, sell - prices[i]);
            int selli = Math.max(sell, hold + prices[i] - fee);
            hold = holdi;
            sell = selli;
        }
        return sell;
        
    }
}
