//27ms
class Solution {
    
    //1. sort the array, for each value i to nums.length - 2
    //2.    target = 0 - i;
    //3.    reduced the problem to 2sum problem, then solve the problem using 2 poionters approach
    //4.    when the value is found, need to skip the same value as the result should be distinct
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        for(int i = 0 ; i < nums.length-2 ; i++) {
            if(i > 0 && nums[i-1] == nums[i]) continue;
            int l = i+1;
            int r = nums.length - 1;
            int target = 0 - nums[i];
            //-4 -1 -1 0 1 2
            while(l<r) {
                //System.out.println("i:"+i+" l:"+l+" r:"+r);
                if( nums[l] + nums[r] > target) {
                    r--;
                } else if (nums[l] + nums[r] < target){
                    l++;
                } else {
                    //nums[l] + nums[r] == target
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[l]);
                    res.add(nums[r]);
                    result.add(res);
                    while(l < nums.length -1 && nums[l+1] == nums[l]){
                        l++;
                    }
                    l++;
                    while(r>0&& nums[r-1] == nums[r]){
                        r--;
                    }
                    r--;
                }
                
            }
        }
        return result;
    }
}



//1980 ms
class Solution {
    
    
    /*
    * build a Map<Integer, Set<Integer>>, containing value, indexSet
    * then for each value
    *   let the value = a
    *      target = 0 - a
    *      reduced the problem to 2sum
    *      for each remaining value, let b = target, c = target - b
    *           find from the map, excluding index of b and index a
    *           for each result, need to cache it, and avoid duplicate, by build another answer map Map<Integer, Set<Integer>> storing (answer[0], answer[1]) (answer[1], answer[2]) where answer is sorted
    */
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Set<Integer>> answerMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        Map<Integer, Set<Integer>> map = buildMap(nums);
        for(int i = 0 ; i < nums.length ; i++) {
            int a = nums[i];
            int target = 0 - nums[i];
            Set<Integer> avoidDuplicate = new HashSet<>();
            for(int j = i + 1; j < nums.length; j++) {
                int b = nums[j];
                if(avoidDuplicate.contains(b)) continue;
                avoidDuplicate.add(b);
                List<Integer> found = find(map, target - b, i, j);  
                //System.out.println("a:" + a +" b:" + b+ " target:" + (target - b) + " found:" + found );
                if(found.size() == 0 ) continue;
                

                for(int n: found) {
                    int[] answerArr = new int[3];
                    answerArr[0] = a;
                    answerArr[1] = b;
                    answerArr[2] = nums[n];
                    Arrays.sort(answerArr);
                    
                    //System.out.println("answerArr:" + Arrays.stream(answerArr).boxed().toList() + " " + "answerMap:" + answerMap);
                    if((!answerMap.containsKey(answerArr[0]) || !answerMap.containsKey(answerArr[1]) )  ||
                      (answerMap.containsKey(answerArr[0]) &&  !answerMap.get(answerArr[0]).contains(answerArr[1]))
                      ) { //avoid duplicate
                        result.add(Arrays.stream(answerArr).boxed().toList());
                        if(answerMap.containsKey(answerArr[0])){
                            Set<Integer> set = answerMap.get(answerArr[0]);
                            set.add(answerArr[1]);
                            answerMap.put(answerArr[0], set);
                        } else {
                            Set<Integer> set = new HashSet<>();
                            set.add(answerArr[1]);
                            answerMap.put(answerArr[0], set);
                        } 
                        if(answerMap.containsKey(answerArr[1])){
                            Set<Integer> set = answerMap.get(answerArr[1]);
                            set.add(answerArr[2]);
                            answerMap.put(answerArr[1], set);
                        } else {
                            Set<Integer> set = new HashSet<>();
                            set.add(answerArr[2]);
                            answerMap.put(answerArr[1], set);
                        } 
                    }
                    
                }
            }
        }
        //System.out.println(result);
        return result;
    }
    
   
    //build the map (number, indexList)
    private Map<Integer, Set<Integer>> buildMap(int[] nums){
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++) {
            if(map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(i);
                map.put(nums[i], set);
            }
        } 
        return map;
    }
    
    //find specific value from the map, excluding certain index
    private List<Integer> find(Map<Integer, Set<Integer>> map, int num, int... excluded){
        List<Integer> result = new ArrayList<>();
        if(map.get(num) == null) {
            return result;
        }
        Set<Integer> set = map.get(num);
        if(excluded == null || excluded.length == 0) {
            set.stream()
            .forEach(each -> result.add(each));
        } else if (excluded.length > 0) {
            set.stream()
            .filter(i -> i != excluded[0])
            .filter(i -> i != excluded[1])
            .forEach(each -> result.add(each));
        }
        return result;
    }
}
