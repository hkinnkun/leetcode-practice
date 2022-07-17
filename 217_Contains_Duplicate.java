class Solution {
    public boolean containsDuplicate(int[] nums) {
        return nums.length != Arrays.stream(nums).boxed().distinct().collect(Collectors.toList()).size();
    }
}

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }
}
