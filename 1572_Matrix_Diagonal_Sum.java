class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;       
        int sum = 0;
        for(int i = 0 ; i < n / 2; i ++) {
            sum += mat[i][i]; //top left
            sum += mat[i][n -1 -i]; //bottom left
            sum += mat[n -1 -i][i]; //top right
            sum += mat[n-1-i][n-1-i]; //bottom right
        }
        if(n%2 != 0) sum += mat[n/2][n/2];
        
        return sum;
    }
}
