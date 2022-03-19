//hashmap

class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    public List<Integer> majorityElement(int[] nums) {
        int target = nums.length/3;
        IntStream.of(nums).boxed().collect(Collectors.toList()).stream().forEach(this::countOccurence);
        return map.entrySet().stream()
            .filter(entry -> entry.getValue() > target)
            .map(e -> e.getKey())
            .collect(Collectors.toList());
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

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //voting algorithm
        int length = nums.length;
        int selected_a = nums[0];
        int selected_b = nums[0];
        int count_a = 0;
        int count_b = 0;
        
        for(int i = 0; i < length; i++) {
            if(selected_a == nums[i]) {
                count_a++;
            } else if (selected_b == nums[i]) {
                count_b++;
            } else if (count_a == 0) {
                selected_a = nums[i];
                count_a++;
            } else if (count_b == 0) {
                selected_b = nums[i];
                count_b++;
            } else {
                count_a--;
                count_b--;
            }
        }
        count_a = 0;
        count_b = 0;
        for(int i = 0; i < length; i++) {
            if(selected_a == nums[i]) {
                count_a++;
            }
            if(selected_b == nums[i]) {
                count_b++;
            }
        }
        List<Integer> result = new ArrayList<>();
        if(count_a > length/3) result.add(selected_a);
        if(count_b > length/3) result.add(selected_b);
        return result.stream().distinct().collect(Collectors.toList());
    }

}