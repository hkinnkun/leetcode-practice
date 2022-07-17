class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] main;
        int[] other;
        if(nums1.length > nums2.length) {
            main = nums1;
            other = nums2;
        } else {
            main = nums2; 
            other = nums1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < main.length; i++) {
           if(map.containsKey(main[i])){
               int count = map.get(main[i]);
               map.put(main[i], ++count);
           }else {
               map.put(main[i], 1);
           }
            
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < other.length; i++) {
           if(map.containsKey(other[i])){
               result.add(other[i]);
               int count = map.get(other[i]);
               if(count == 1) {
                   map.remove(other[i]);
               } else {
                   map.put(other[i], --count);
               }
            } else {
           }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}