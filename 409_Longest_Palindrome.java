class Solution {
    
    private Map<Character, Integer> map = new HashMap<>();
    
    public int longestPalindrome(String s) {
        s.chars().mapToObj(c -> (char) c).forEach(this::countOccurence);
        List<Integer> list = new ArrayList<Integer>(map.values());
        int result = 0;
        //use all >1 occurence character to form palindrome
        for(int i = 0; i < list.size(); i++) {
            int val = list.get(i);
            if(isEven(val) && val > 0){
                result+=val;
                list.set(i, 0);
            }
            if(!isEven(val) && val > 2) {
                result+=val-1;
                list.set(i, 1);
            }
        }
        
        //if there is one char left, then use it to maximize the length
        for(int i = 0; i < list.size(); i++) {
            int val = list.get(i);
            if(!isEven(val) && val > 0){
                result++;
                break;
            }
        }
        return result;
        
    }
    
    private void countOccurence(char c){
        if(map.containsKey(c)) {
            int count = map.get(c);
            map.put(c, ++count);
        } else {
            map.put(c, 1);
        }
    }
    
    private boolean isEven(int i){
        return (i % 2) == 0;
    }
}

class Solution {
    
   
    public int longestPalindrome(String s) {
       Set<Character> countingSet = new HashSet<>();
        int result = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(countingSet.contains(c)) {
                result += 2;
                countingSet.remove(c);
            } else {
                countingSet.add(c);
            }

        }
       
        return countingSet.isEmpty() ? result : result + 1;
    }
    
}