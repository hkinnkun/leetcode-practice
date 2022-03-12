class Solution {
    
    /**
    1. save the original array
    2. get sorted array
    3. get the largest k nums
       put the largest k nums into a resultMap as <nums, count>
    4. iterate the original array, if the number is in the [largest k number], put it into the result
       and decrease the count from the map. if conut==0, remove it.
       (this way we can keep the order of the numer)
    **/
    
    
    public int[] maxSubsequence(int[] nums, int k) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        int[] nums_original = new int[nums.length]; //save the original array
        for(int i = 0; i < nums.length; i++) {
            nums_original[i] = nums[i];
        }
        Arrays.sort(nums);
        for(int i = nums.length - 1; i >= nums.length - k ; i--) {
            if(resultMap.containsKey(nums[i])){
                int count = resultMap.get(nums[i]);
                resultMap.put(nums[i], ++count);
            } else {
                resultMap.put(nums[i], 1);
            }
        }
        int[] result = new int[k];
        int j = 0;
        for(int i = 0; i < nums_original.length; i++) {
            if(resultMap.containsKey(nums_original[i])){
                int count = resultMap.get(nums_original[i]);
                result[j] = nums_original[i];
                j++;
                if(count == 1) {
                    resultMap.remove(nums_original[i]);
                } else {
                    resultMap.put(nums_original[i], --count);
                }
            } 
        }
        return result;
    }
}