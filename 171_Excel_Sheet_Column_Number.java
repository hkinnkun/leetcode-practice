class Solution {
    public int titleToNumber(String columnTitle) {
        //char A = 65
        int output = 0;
        for(int i = columnTitle.length() - 1 , j = 0; i >= 0 ; i--, j++) {
            char c = columnTitle.charAt(i);
            output +=  (c - 64)  * Math.pow(26, j);
        }
        return output;
    }    
}
