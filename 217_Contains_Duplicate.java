class Solution {
    public boolean containsDuplicate(int[] nums) {
        return nums.length != Arrays.stream(nums).boxed().distinct().collect(Collectors.toList()).size();
    }
}