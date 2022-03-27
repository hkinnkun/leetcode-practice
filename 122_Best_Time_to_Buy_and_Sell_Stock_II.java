class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy_price = prices[0];
        for(int i = 0; i < prices.length; i++) {
            int temp_profit  = prices[i] - buy_price; 
            if( temp_profit > 0) {
                profit+= temp_profit; //if next day has profit, we sell and take the profit, else, we ignore it
            }
            buy_price = prices[i]; // buy on each day 
        }
        return profit;
    }
}