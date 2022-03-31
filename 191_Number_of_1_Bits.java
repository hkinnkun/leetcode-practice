public class Solution {
    // you need to treat n as an unsigned value
	// >> to preseve sign
	// >>> doesnt 
	//https://stackoverflow.com/questions/1034640/javas-versus-operator
	//Hamming weight
    //sideways addition
    //native approach
    //https://graphics.stanford.edu/~seander/bithacks.html#CountBitsSetParallel
    //https://groups.google.com/g/comp.graphics.algorithms/c/ZKSegl2sr4c/m/QYTwoPSx30MJ?hl=en&pli=1
    //https://stackoverflow.com/questions/10874012/how-does-this-bit-manipulation-work-in-java/10874449#10874449
    //https://stackoverflow.com/questions/21131932/how-does-this-code-work-to-count-number-of-1-bits
	//https://leetcode.com/problems/number-of-1-bits/discuss/55120/Short-code-of-C%2B%2B-O(m)-by-time-m-is-the-count-of-1's-and-another-several-method-of-O(1)-time
    public int hammingWeight(int n) {
        int result = 0;
        while(n != 0) {
            if((n & 1) == 1) {
                result++;
            }
            n = n >>> 1;
        }
        return result;        
    }
}

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        n = (n & (0x55555555)) + ((n >>> 1) & (0x55555555)); //consecutive 2 bits
        n = (n & (0x33333333)) + ((n >>> 2) & (0x33333333)); //consecutive 4 bits
        n = (n & (0x0f0f0f0f)) + ((n >>> 4) & (0x0f0f0f0f)); //consecutive 8 bits
        n = (n & (0x00ff00ff)) + ((n >>> 8) & (0x00ff00ff)); //consecutive 16 bits
        n = (n & (0x0000ffff)) + ((n >>> 16) & (0x0000ffff)); //consecutive 32 bits
        return n;

    }
    
    
}
/*
1011
#1
	1011
	0101
=	0001
n>>1
	0101
	0101
=	0101

ans:0110

#2 
	0110
	0011
=	0010
n>>2
	0001
	0011
=	0001
ans:0011

final answer = 0011 = 3 = counts of 1s in consecutive 4 bits

0x55555555=01010101010101010101010101010101
0x33333333=00110011001100110011001100110011
0x0f0f0f0f=00001111000011110000111100001111
0x00ff00ff=00000000111111110000000011111111
0x0000ffff=00000000000000001111111111111111
*/