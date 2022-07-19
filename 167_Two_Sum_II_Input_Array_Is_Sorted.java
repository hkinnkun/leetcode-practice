//two pointer approach
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0 ;
        int r = numbers.length-1;
        while(l<r){
            if( numbers[l] + numbers[r] > target) {
                r--;
            } else if (numbers[l] + numbers[r] < target){
                l++;
            } else {
                //numbers[l] + numbers[r] == target
                int[] result = new int[2];
                result[0] = l+1; //add one as question requested
                result[1] = r+1; //add one as question requested
                return result;
            }
        }
        return new int[2];
    }
}
