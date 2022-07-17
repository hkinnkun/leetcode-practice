class Solution {
    public int search(int[] nums, int target) {
        int h = nums.length - 1;
        int l = 0;
        while(l <= h) {
            //int m = (l + h) / 2; 
            // l + h may overflow
            // h = l+h-l
            // m = (l + h) / 2; 
            // 2m = l + h
            // 2m = l + l + h - l
            // 2m = 2l + h - l
            // m = l + (h-l)/2
            int m = l + (h-l)/2;
            if(target > nums[m]) l = m + 1;
            if(target < nums[m]) h = m - 1;
            if(target == nums[m]) return m;
        }
        return -1;
    }
}
