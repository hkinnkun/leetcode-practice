

class Solution {
    public boolean isPalindrome(String s) {
        if (isBlank(s)) return true;
        s = cleanup(s);
        return s.equals(reverse(s));
    }
    
    private String cleanup(String s){
        return s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
    }
    
    private String reverse(String s) {
        byte[] originalByteArr = s.getBytes();
        byte[] reversedByteArr = new byte[originalByteArr.length];
        for (int i = 0; i < reversedByteArr.length; i++) {
            reversedByteArr[i] = originalByteArr[originalByteArr.length - i - 1];
        }
        return new String(reversedByteArr);
    }
    
    
    private boolean isBlank(final CharSequence cs) {
        final int strLen = length(cs);
        if (strLen == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    private int length(final CharSequence cs) {
        return cs == null ? 0 : cs.length();
    }
    
}