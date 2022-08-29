class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0;
        int end = 0;
        int longest = 0;
        int n = s.length();
        int newStart = 0;//next index of different character
        int tolerable = k;
        char c = s.charAt(start);
        while(end < n ) {
            //System.out.println("start:"+start +" end:" + end +" newStart:" + newStart + " tolerable:"+tolerable+" longest:"+longest+" c"+c+" s.charAt("+end+"):" + s.charAt(end));
            if(c != s.charAt(end) && tolerable > 0) {
                if(newStart == start) {
                    newStart = end;
                }
                tolerable--;

            } else if (c != s.charAt(end) && tolerable == 0) {
                if(newStart == start) {
                    newStart = end;
                }
                start = newStart;
                end = start;
                tolerable = k;
                c = s.charAt(start);
                continue;
            }
            longest = Math.max(longest, end - start + 1);
            end++;
        }
        
        //for some edge case, we need to do in reverse order
        String reversed = new StringBuilder(s).reverse().toString();
        start = 0;
        end = 0;
        newStart = 0;
        tolerable = k;
        while(end < n ) {
            //System.out.println("start:"+start +" end:" + end +" newStart:" + newStart + " tolerable:"+tolerable+" longest:"+longest+" c"+c+" reversed.charAt("+end+"):" + reversed.charAt(end));
            if(c != reversed.charAt(end) && tolerable > 0) {
                if(newStart == start) {
                    newStart = end;
                }
                tolerable--;

            } else if (c != reversed.charAt(end) && tolerable == 0) {
                if(newStart == start) {
                    newStart = end;
                }
                start = newStart;
                end = start;
                tolerable = k;
                c = reversed.charAt(start);
                continue;
            }
            longest = Math.max(longest, end - start + 1);
            end++;
        }
        
        
        
        
        
        return longest;
    }
}









class Solution {
    //first for char at start
    //we assume to use it in the result
    //we do a sliding windows approach to scan the string, with up to k char which is not matching the s.charAt(start)
    //then we shift start + 1
    public int characterReplacement(String s, int k) {
        int start = 0;
        int end = 0;
        int longest = 0;
        int n = s.length();
        int newStart = 0;//next index of different character
        int tolerable = k;
        char c = s.charAt(start);
        while(end < n ) {
            //System.out.println("start:"+start +" end:" + end +" newStart:" + newStart + " tolerable:"+tolerable+" longest:"+longest+" c"+c+" s.charAt("+end+"):" + s.charAt(end));
            if(c != s.charAt(end) && tolerable > 0) {
                if(newStart == start) {
                    newStart = end;
                }
                tolerable--;

            } else if (c != s.charAt(end) && tolerable == 0) {
                if(newStart == start) {
                    newStart = end;
                }
                start = newStart;
                end = start;
                tolerable = k;
                c = s.charAt(start);
                continue;
            }
            longest = Math.max(longest, end - start + 1);
            end++;
        }
        
        //for some edge case, we need to do in reverse order
        String reversed = new StringBuilder(s).reverse().toString();
        start = 0;
        end = 0;
        newStart = 0;
        tolerable = k;
        while(end < n ) {
            //System.out.println("start:"+start +" end:" + end +" newStart:" + newStart + " tolerable:"+tolerable+" longest:"+longest+" c"+c+" reversed.charAt("+end+"):" + reversed.charAt(end));
            if(c != reversed.charAt(end) && tolerable > 0) {
                if(newStart == start) {
                    newStart = end;
                }
                tolerable--;

            } else if (c != reversed.charAt(end) && tolerable == 0) {
                if(newStart == start) {
                    newStart = end;
                }
                start = newStart;
                end = start;
                tolerable = k;
                c = reversed.charAt(start);
                continue;
            }
            longest = Math.max(longest, end - start + 1);
            end++;
        }
        
        
        
        
        
        return longest;
    }
}








class Solution {
    //we keep track of freq of char in the sliding windows
    //then we find the window_len - most freq char count <= k
    //else we shift start = start + 1
    public int characterReplacement(String s, int k) {
        int start = 0;
        int end = 0;
        int[] arr = new int[26];
        int n = s.length();
        int longest = 0;
        while(end < n) {
            arr[s.charAt(end) - 'A']++;
            int windowLen = end - start + 1;
            int maxOcc = Arrays.stream(arr).max().getAsInt();
            if(windowLen - maxOcc > k) {
                arr[s.charAt(start) - 'A']--;
                start++;
            }
            longest = Math.max(longest, end - start + 1);
            end++;
        }
        return longest;
    }
}
