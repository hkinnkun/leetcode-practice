/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    //Binary Search approach
    public int guessNumber(int n) {
        int low = 0 ;
        int high = n;
        int m = low + (high - low) / 2;
        int res = guess(m);
        while(res!=0) {
            if(res > 0) {
                low = m + 1;
                high = high;
                m = low + (high - low) / 2;
                res = guess(m);
            } 
            if (res < 0) {
                low = low;
                high = m - 1;
                m = low + (high - low) / 2;
                res = guess(m);
            }
        }
        return m;
    }
}
