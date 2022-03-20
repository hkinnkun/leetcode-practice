//maintain a map <num, occurrence>
//The question is asking in a window of size (k + 1), find the min diff <= t
//we maintain a TreeMap, where key is sorted
//when we add element, we calculate the min diff
//if already have in the map, must be 0, and return true
//remove, we dont have to calculate as removing one element in the map does not bring you a lower diff

class Solution {
    
    TreeMap<Integer, Integer> map = new TreeMap<>();
    long diff = Long.MAX_VALUE;
    int total_count = 0;
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for(int i = 0; i < nums.length; i++) {
            if(total_count > k) {
                remove(nums[i-k-1]);
            }
            add(nums[i]);
            //System.out.println(map + " minDiff is " + minDiff);  
            if(diff <= t) return true;
        }
         return false;
    }
    
    private void add(int i) {
        if(map.containsKey(i)) {
            int count = map.get(i);
            map.put(i, ++count);
            total_count++;
            diff = 0;
        } else {
            updateDiffAndPut(i);
        }
    }
    
    private void remove(int i) {
        int count = map.get(i);
        if(count == 1) {
            map.remove(i);
            total_count--;
        } else {
            map.put(i, --count);
        }
    }
    
    private void updateDiffAndPut(int i){
        total_count++;
        if(map.size()==0) {
            map.put(i, 1);
            return;
        }
        if(i <= map.firstKey()) {
            diff = (long) map.firstKey() - (long) i;
            map.put(i, 1);    
        } else if (i >= map.lastKey()) {
            diff = (long) i - (long) map.lastKey();
            map.put(i, 1);
        } else {
            map.put(i, 1);
            int lowerKey = map.lowerKey(i);
            int higherKey = map.higherKey(i);
            long higher_diff = (long) higherKey - (long) i;
            long lower_diff = (long) i - (long) lowerKey;
            if(lower_diff < higher_diff) {
                diff = lower_diff;
            } else {
                diff = higher_diff;
            }
        }
    }
    
}