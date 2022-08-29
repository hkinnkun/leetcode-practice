class Solution {
    //[1,2,3,4]
    //[1,2,6,24]
    //[24,24,12,4]
    
    
    //if without using extra array
    //[1,2,6,24] => [ 24,    12   ,8,6]
    //first we have a prefix product, storing in result
    //then we go in reverse order, store the postfix product in an temp variable
    //then modify the result array to get the product except self
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for(int i = 0; i < n; i++) {
            if(i==0) {
                result[0] = nums[i];
                continue;
            }
            result[i] = result[i-1] * nums[i];
        }
        int postfix = 1;
        for(int i = n-1; i >= 0; i--) {
            if(i==n-1) {
                result[i] = result[i-1];
                postfix = nums[i];
                continue;
            }
            if(i==0) {
                result[i] = postfix;
                continue;
            }
            result[i] = result[i-1] * postfix;
            postfix = postfix * nums[i];
        }
        return result;
    }
}
