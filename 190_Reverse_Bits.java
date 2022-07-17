public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int mask = 0b1;
        int result = 0;
        for(int i = 0 ; i < 32; i++){
            int lastBit = n & mask; //preseve last bit
            //System.out.println("Last bit is " + lastBit);
            result = result | lastBit; 
            //System.out.println("Result is " + Integer.toBinaryString(result));
            if(i < 31) {
                n = n >>> 1;
                result = result << 1;
            }
        }
        return result;
    }
}
