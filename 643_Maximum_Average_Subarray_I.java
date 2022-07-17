class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double result = Integer.MIN_VALUE;
        int sum = 0 ;
        for(int i = 0 ; i < k; i++){
            sum += nums[i];
        }
        result = sum / (double) k;
        for(int i = k; i < nums.length; i++) {
            sum = sum - nums[i-k]  + nums[i];
            double temp_result = sum / (double) k;
            if(temp_result > result) result = temp_result;
        }
        return result;
    }
}

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double result = Integer.MIN_VALUE;
        int sum = 0 ;
        for(int i = 0 ; i < k; i++){
            sum += nums[i];
        }
        result = sum / (double) k;
        double temp_result = 0;

        for(int i = k; i < nums.length; i++) {
            sum = sum - nums[i-k]  + nums[i];
            temp_result = sum / (double) k;
            if(temp_result > result) result = temp_result;
        }
        return result;
    }
}

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double result = Integer.MIN_VALUE;
        int sum = 0 ;
        for(int i = 0 ; i < k; i++){
            sum += nums[i];
        }
        result = sum / (double) k;
        for(int i = k; i < nums.length; i++) {
            sum = sum - nums[i-k]  + nums[i];
            result = Math.max(result ,sum / (double) k);
        }
        return result;
    }
}