class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int max = 0;
        char[] c = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>(); 
        while(end < c.length) {
            //System.out.println("Start:end=" + start+":"+end + " " + c[end]);
            if(map.containsKey(c[end])){
                //clear char in map from start to next start
                int newStart = map.get(c[end]);
                for(int i = start ; i < newStart; i++){
                    map.remove(c[i]);
                }
                map.put(c[end], end);
                start = newStart + 1;
                end++;
                max = Math.max(end-start, max);
            } else {
                map.put(c[end], end);
                end++;
                max = Math.max(end-start, max);
            }
        }
        return max;
    }
    
}

//slow
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int max = 0;
        char[] c = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>(); 
        while(end < c.length) {
            //System.out.println("Start:end=" + start+":"+end + " " + c[end]);
            if(map.containsKey(c[end])){
                start = map.get(c[end]) + 1;
                end = start;
                map.clear();
            } else {
                map.put(c[end], end);
                end++;
                max = Math.max(end-start, max);
            }
        }
        return max;
    }
    
}

//slow
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 1;
        int max = 0;
        for( ; end <= s.length() && start < s.length();) {
            String temp = s.substring(start, end);
            if(!hasDuplicate(temp)) {
                max = Math.max(end-start, max);
                end++;
            } else {
                start = start + 1;
            }
        }
        return max;
    }
    
    private boolean hasDuplicate(String s){
        //System.out.println("substring is " + s);
        return s.length() != s.chars().distinct().count();
    }
}

//slow
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 1;
        int max = 0;
        for( ; end <= s.length() && start < s.length();) {
            String temp = s.substring(start, end);
            if(!hasDuplicate(temp)) {
                max = Math.max(end-start, max);
                end++;
            } else {
                start = start + 1;
            }
        }
        return max;
    }
    
    private boolean hasDuplicate(String s){
        System.out.println("substring is " + s);
        return s.length() != s.chars().distinct().count();
    }
}

