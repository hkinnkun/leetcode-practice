class Solution {
    public int strStr(String haystack, String needle) {
        if("".equals(needle)) return 0;
        if(haystack.equals(needle)) return 0;
        
        int haystack_len = haystack.length();
        int needle_len = needle.length();
                
        for(int i = 0; i <= haystack_len - needle_len; i++) {
            String temp = haystack.substring(i, i+needle_len);
            //System.out.println("haystack:"+haystack+" temp:"+temp);
            if(temp.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
