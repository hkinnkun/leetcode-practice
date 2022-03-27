class Solution {
  //Kadane’s Algorithm
    public int maxSubArray(int[] nums) {
		if (nums.length == 1) return nums[0];
		int globalMax = nums[0];
		int localMax = nums[0];
		for(int i = 1 ; i < nums.length ; i++){
			localMax = Integer.max(nums[i], nums[i] + localMax);
			if(localMax > globalMax) globalMax = localMax;
		}
		return globalMax;
    }
}
