class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1) return 0;
        int max_profit = 0;
        int min_price = prices[0];
        int max_price = prices[0];
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < min_price) { // if we see a lower buying price, we will update it
                min_price = prices[i];
                max_price = prices[i];
            } else if (prices[i] > max_price) {  //if we see a higher selling price, we update the current max price
                max_price = prices[i];
            }
            int temp_profit = max_price - min_price;  //caculate the current profit
            if(temp_profit > max_profit) max_profit = temp_profit; //see if the current is the max
        }
        return max_profit;
    }
}