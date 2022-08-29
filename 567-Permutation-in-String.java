class Solution {
    
    //first we record the character freq. of s1 into a map
    //then we iterate in s2 for all substring of s1.length()
    //then check if the substring is a permutation of s1 (check if the character occurrence freq is the same)
    
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c: s1.toCharArray()) {
            int count = map.getOrDefault(c, 0); 
            map.put(c, count + 1);
        }
        //map.entrySet().forEach(entry -> {System.out.println(entry.getKey() + ":" + entry.getValue());});
        
        int s1Len = s1.length();
        boolean result = false;
        for(int i = 0 ; i <= s2.length() - s1Len; i++){
            String substringOfS2 = s2.substring(i, i+s1Len);
            //System.out.println("substringOfS2:"+substringOfS2);
            if(isPermutation(substringOfS2, map)) {
                result = true;
                break;
            }
        }
        return result;
    }
    
    private boolean isPermutation(String s, Map<Character,Integer> map) {
        int[] arr = new int[26];
        for(char c: s.toCharArray()) {
            if(!map.containsKey(c)) return false; //short circuit if the character is not found in the map
            arr[c-'a']++;
        }
        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            int c = entry.getKey();
            int index = entry.getKey() - 'a';
            arr[index] -= entry.getValue();
        }

        for(int i: arr){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
}







class Solution {
    
    //first we record the character freq. of s1 into an array s1
    //we do a sliding window approach for all substring of s1.length
    //if all matches = return true;
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];

        for(int i = 0 ; i < s1.length(); i++) {
            s1Arr[s1.charAt(i) - 'a']++;
            s2Arr[s2.charAt(i) - 'a']++;
        }
        //System.out.println("s1Arr:"+Arrays.toString(s1Arr));
        //System.out.println("s2Arr:"+Arrays.toString(s2Arr));

        if(isMatches(s1Arr, s2Arr)) return true;
        int s1Len = s1.length();
        int s2Len = s2.length();
        for(int i = 0; i < s2Len - s1Len; i++) {
            char removed = s2.charAt(i);
            s2Arr[removed - 'a']--;
            char added = s2.charAt(i+s1Len);
            s2Arr[added - 'a']++;
            //System.out.println("removed:" + removed + " added:"+added+" "+Arrays.toString(s2Arr));
            if(isMatches(s1Arr, s2Arr)) return true;
        }
        return false;
    }
    
    //assume same len
    private boolean isMatches(int[] a, int[] b){
        for(int i = 0; i < a.length; i++){
            if(a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

}
