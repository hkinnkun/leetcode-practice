class Solution {
    public int[] countBits(int n) {
        int closestPowerOf2 = 0;
        int[] result = new int[n+1];
        for (int i = 0 ; i < result.length; i ++) {
            if(i == 0) continue;
            if(i == 1) {
                result[i] = 1;
                continue;
            }
            if(isPowerOf2(i)) {
                closestPowerOf2 = i;
                result[i] = 1;
            } else {
                result[i] = 1 + result[i - closestPowerOf2];
            }
        }
        return result;
    }
    
    private boolean isPowerOf2(int x) {
        return (x & (x - 1)) == 0;
    }
}
//idea: 9 1001
//  9 1001 = 1 + f(001) = 1 = 2
// 14 1110 = 1 + f(110) = 2 = 3

/*
0000  0 0
0001  1 1
0010  2 1
0011  3 2
0100  4 1
0101  5 2
0110  6 2
0111  7 3
1000  8 1
1001  9 2
1010 10 2
1011 11 2
1100 12 3
1101 13 3
1110 14 3 
1111 15 4

*/
