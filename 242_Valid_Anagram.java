class Solution {
    public boolean isAnagram(String s, String t) {
        int[] s_arr = new int[26];
        int[] t_arr = new int[26];
        s.chars().mapToObj(c -> (char) c).forEach(c -> s_arr[char2Int(c) - 10]++);
        t.chars().mapToObj(c -> (char) c).forEach(c -> t_arr[char2Int(c) - 10]++);
        boolean result = true;
        for( int i = 0; i < s_arr.length; i++) {
            if(s_arr[i] != t_arr[i]){
                result = false;
                break;
            }
        }
        return result;
    }
    
    private int char2Int(char c){
        return Character.getNumericValue(c);
    }
}
