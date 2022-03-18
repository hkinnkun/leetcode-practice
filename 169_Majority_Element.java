//HashMap
class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    public int majorityElement(int[] nums) {
        IntStream.of(nums).boxed().collect(Collectors.toList()).stream().forEach(this::countOccurence);
        return map.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
    }
    private void countOccurence(int i){
        if(map.containsKey(i)){
            int o = map.get(i);
            map.put(i, ++o);
        } else {
            map.put(i, 1);
        }
    }
}

//sorting
class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int target_count = nums.length / 2;
        int trace_index = 0;
        int num = nums[0];
        int count = 0;
        while(true) {
            if(count >= target_count) return nums[trace_index];
            if(num != nums[trace_index]) {
                num = nums[trace_index];
                count = 1;
            } else {
                count++;
                trace_index++;
            }
        }
    }
}

//Boyer-Moore Voting Algorithm
class Solution {
    public int majorityElement(int[] nums) {
        Integer candidate = null;
        int count = 0;
        for(int num : nums) {
           if (count == 0)  {
               candidate = num;
           }
            if(num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}