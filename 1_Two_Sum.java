class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++) {
            if(map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        } 
        
        for(int i = 0 ; i < nums.length; i++){
            int other = target - nums[i];
            List<Integer> list = map.get(other);
            if(list == null) continue;
            int[] result = new int[2];
            if(other != nums[i]) {
                result[0] = i;
                result[1] = list.get(0);
                return result;
            } else {
                
                if(list.size() > 1) {
                    result[0] = list.get(0);
                    result[1] = list.get(1);
                    return result;
                }

            }
        }
        return null;
        
    }
}
