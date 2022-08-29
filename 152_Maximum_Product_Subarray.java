class Solution {
    //all positive [1,2,3] = all
    //all negative [-1,-2,-3] => need to remember the min and max, as current min plus next negative number can become next max
    public int maxProduct(int[] nums) {
        int localMax = 1;
        int localMin = 1;
        int globalMax = Integer.MIN_VALUE;
        for (int i = 0 ; i < nums.length; i++ ){
            if(nums[i] == 0) {
                localMax = 1;
                localMin = 1;
            }
            int temp = nums[i] * localMax;
            localMax = Math.max(Math.max(nums[i], nums[i] * localMin),  temp);
            localMin = Math.min(Math.min(nums[i], nums[i] * localMin), temp );
            globalMax = Math.max(globalMax, localMax);
            //System.out.println("localMax is " + localMax + " localMin is " + localMin + " globalMax is " + globalMax);
        }
        return globalMax;

    }
}
