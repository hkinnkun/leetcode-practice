class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int i=0;
        int j=0;
        while(i < g.length && j < s.length){
            if(s[j]>=g[i]){
                i++;
                j++;
                result++;
            } else {
                j++;
            }
        }
        return result;
    }
}
                           

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        List<Integer> g_sorted = Arrays.stream(g).boxed().sorted().collect(Collectors.toList());
        List<Integer> s_sorted = Arrays.stream(s).boxed().sorted().collect(Collectors.toList());
        int result = 0;
        for(int i = 0; i < g_sorted.size(); i++){
            for(int j =0; j<s_sorted.size(); j++) {
                if(s_sorted.get(j) >= g_sorted.get(i)) {
                    result++;
                    s_sorted.remove(j);
                    break;
                }                
            }            
        }
        return result;
    }
}
                                                                           						   
																		   