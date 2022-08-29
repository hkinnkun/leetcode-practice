class Solution {
    
    //build a board like this
    //     0 1 2 3 4      
    //     b a b a d
    // 0 b T F   
    // 1 a   T F
    // 2 b     T F
    // 3 a       T F 
    // 4 d         T
    // 0,0 = from 0 to 0, is it palindromic ?  i,i all true
    // 0,1 = from 0 to 1, is it palindromic ?  
    // from 1, 3 is it palindromic ?  if char 1 == char 3, and subString (start + 1, end- 1) also palindromic then true
    
    public String longestPalindrome(String s) {
        int n = s.length();
        int longest_start = 0;
        int longest_end = 0;
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n ; i ++) {
            dp[i][i]= true;
        }
        for(int i = 0, j=i+1; i < n && j < n ; i ++, j++) {
            if(s.charAt(i)==s.charAt(j)) {
                dp[i][j] = true;
                longest_start = i;
                longest_end = j;
            }
        }

        // (i,i) & (i, i+1) needs to pre-process first
        // then we start from 0,2 -> 1,3, 2,4... diagonally..
        // then 0,3 -> 1,4 ....
        // then 0,4 -> 1,5....
        
        for(int k = 2; k < n; k++) {
            for(int i = 0, j = i +k; i<n&&j<n; i++,j++){
                //System.out.println("processing i:"+i+" j:"+j);
                 if(s.charAt(i)==s.charAt(j) && 
                   dp[i+1][j-1] == true
                   ) {
                    dp[i][j] = true;
                    longest_start = i;
                    longest_end = j;
                }           
            }

        }
        //System.out.println(Arrays.deepToString(dp));
        //System.out.println("start:"+longest_start+" end:"+longest_end);
        
        return s.substring(longest_start, longest_end+1);
    }
}
