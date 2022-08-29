class Solution {
    
    //greedy = pick greatest , but not an optimal solution.
    //DP
    //Bottom Up
    //for example 7, [1,3,4,5], greedy = 5 , 1 ,1; optimal is 3,4
    //set all DP arrays to be amount + 1, essentially the maximum value
    //DP[1] = 1
    //DP[2] = 1 + DP[1] (use coin 1 plus DP[1])
    //DP[3] = 1 (use coin 3)
    //DP[4] = 1 (use coin 4)
    //DP[5] = 1 (use coin 5)
    //DP[6] = Min(1 + DP[5], 1 + DP[3], 1 + DP[2], 1 + DP[1])
    //DP[7] = Min(1+ DP[6], 1 + DP[4], 1+ DP[3], 1+DP[2])
    
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        int max = amount + 1;
        Arrays.fill(dp, max);
        dp[0] = 0;
        Set<Integer> coinSet = new HashSet<>();
        for(int i = 0 ; i < coins.length; i++){
            coinSet.add(coins[i]);
        }
        for(int i = 1; i <= amount; i++) {
            if(coinSet.contains(i)) {
                dp[i] = 1;
            } else {
                for(int coin: coins) {
                    if(coin > i) break;
                    dp[i] = Math.min(dp[i],   dp[i - coin] + 1);
                }
            }
        }
        //System.out.println(Arrays.toString(dp));
        return dp[amount] == max ? -1 : dp[amount];
        
    }
}
