class Solution {
    
   
    public int romanToInt(String s) {
        int result = 0;
        char[] c = s.toCharArray();
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
        for(int i = c.length - 1 ; i >= 0;) {
           if(i > 0 ) {
               if ( (c[i] == 'V' || c[i] == 'X') && c[i-1] == 'I') {
                   result+=roman.get(c[i--]);
                   result-=roman.get(c[i--]);
               } else if ( (c[i] == 'L' || c[i] == 'C') && c[i-1] == 'X') {
                   result+=roman.get(c[i--]);
                   result-=roman.get(c[i--]);
               } else if ( (c[i] == 'D' || c[i] == 'M') && c[i-1] == 'C') {
                   result+=roman.get(c[i--]);
                   result-=roman.get(c[i--]);
               } else {
                    result += roman.get(c[i--]);    
               }
           } else {
               result += roman.get(c[i--]);
           }
        }
        return result;
    }
    
}




class Solution {
    
   
    public int romanToInt(String s) {
        int result = 0;
        char[] c = s.toCharArray();
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
        for(int i = c.length - 1 ; i >= 0;) {
           if(i > 0 ) {
               if ( (c[i] == 'V' || c[i] == 'X') && c[i-1] == 'I' || 
                    (c[i] == 'L' || c[i] == 'C') && c[i-1] == 'X' || 
                     (c[i] == 'D' || c[i] == 'M') && c[i-1] == 'C'
                  ) {
                   result+=roman.get(c[i--]);
                   result-=roman.get(c[i--]);
               } else {
                    result += roman.get(c[i--]);    
               }
           } else {
               result += roman.get(c[i--]);
           }
        }
        return result;
    }
    
}



class Solution {
    
   
    public int romanToInt(String s) {
        int result = 0;
        char[] c = s.toCharArray();
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
        char last = 'A';
        for(int i = c.length - 1 ; i >= 0; i--) {
            if(c[i] == 'I' && (last == 'V' || last == 'X') ||
              c[i] == 'X' && (last == 'L' || last == 'C') ||
              c[i] == 'C' && (last == 'D' || last == 'M') 
              ) {
                result -= roman.get(c[i]);
                last = c[i];
            } else {
                result += roman.get(c[i]);
                last = c[i];
            }
        }
        return result;
    }
    
}



class Solution {
    static Map<Character, Integer> roman = new HashMap<>();
    {
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
    }
   
    public int romanToInt(String s) {
        int result = 0;
        char[] c = s.toCharArray();
        char last = 'A';
        for(int i = c.length - 1 ; i >= 0; i--) {
            if(c[i] == 'I' && (last == 'V' || last == 'X') ||
              c[i] == 'X' && (last == 'L' || last == 'C') ||
              c[i] == 'C' && (last == 'D' || last == 'M') 
              ) {
                result -= roman.get(c[i]);
                last = c[i];
            } else {
                result += roman.get(c[i]);
                last = c[i];
            }
        }
        return result;
    }
    
}


