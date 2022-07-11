class Solution {

//Set
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        return set.iterator().next();
    }
	
	//sum
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        int sum_arr=0;
        for(int i = 0; i < nums.length; i++){
            sum_arr += nums[i];
        }
        int uni_num_sum = 0;
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            uni_num_sum += iterator.next();
        }
        return uni_num_sum * 2 - sum_arr;
    }
	
	
	//XOR
	    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            result ^= nums[i];

        }
        return result;
    }

	
	
	
}