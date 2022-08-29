class Solution {
    
    
    //text1=abcde
    //text2=ace
    //build a board
    //DP
    //   a c e
    // a 1 1 1
    // b 1
    // c 1
    // d 1
    // e 1
    //
    // 1. first fill in the edge 
    // 2. then for each remaining, if text(i) == text(j) , then dp[i][j] = DP[i - 1][j - 1] + 1 (for example, 1,2 = c != c, means we are checking ac & abc   <-  a and ab has 1 common, c and c is common, then dp[1][2] = 1+1 =2
    //  if text(i) != text(j) => we take the max(DP[i - 1][j], DP[i][j - 1]) ; for example 1,1 b != c, means we are checking ac & ab, then we are using the max of a& ab , ac & a as dp[i][j]
    // output the max in dp

    
    public int longestCommonSubsequence(String text1, String text2) {
        int max = 0;
        
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1][n2];
        
        
        if(text1.charAt(0) == text2.charAt(0)) {
            dp[0][0] = 1;
            max = Math.max(max, 1);
        }
        for(int i = 1; i < n1 ; i++){
            if(text1.charAt(i) == text2.charAt(0) || dp[i-1][0] == 1) {
                dp[i][0] = 1;
                max = Math.max(max, 1);
            } 
        }
        
        
        for(int j = 1; j < n2 ; j++){
            if(text2.charAt(j) == text1.charAt(0) || dp[0][j-1] == 1) {
                dp[0][j] = 1;
                max = Math.max(max, 1);
            } 
        }
        
        for(int i = 1; i < n1; i++){
            for(int j = 1; j < n2; j++) {
                if(text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        
        //System.out.println(Arrays.deepToString(dp));
        return max;
    }
}









class Solution {
    
    
    //text1=abcde
    //text2=ace
    //build a board
    //DP
    //   a c e
    // a 1 1 1
    // b 1
    // c 1
    // d 1
    // e 1
    //
    // 1. first fill in the edge 
    // 2. then for each remaining, if text(i) == text(j) , then dp[i][j] = DP[i - 1][j - 1] + 1 (for example, 1,2 = c != c, means we are checking ac & abc   <-  a and ab has 1 common, c and c is common, then dp[1][2] = 1+1 =2
    //  if text(i) != text(j) => we take the max(DP[i - 1][j], DP[i][j - 1]) ; for example 1,1 b != c, means we are checking ac & ab, then we are using the max of a& ab , ac & a as dp[i][j]
    // output the max in dp (=return the last one)

    
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1][n2];
        
        
        if(text1.charAt(0) == text2.charAt(0)) {
            dp[0][0] = 1;
        }
        for(int i = 1; i < n1 ; i++){
            if(text1.charAt(i) == text2.charAt(0) || dp[i-1][0] == 1) {
                dp[i][0] = 1;
            } 
        }
        
        
        for(int j = 1; j < n2 ; j++){
            if(text2.charAt(j) == text1.charAt(0) || dp[0][j-1] == 1) {
                dp[0][j] = 1;
            } 
        }
        
        for(int i = 1; i < n1; i++){
            for(int j = 1; j < n2; j++) {
                if(text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        //System.out.println(Arrays.deepToString(dp));
        return dp[n1-1][n2-1];
    }
}
