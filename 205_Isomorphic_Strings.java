class Solution {
    private int s_count;
    private int t_count;
    private Map<Character, Integer> s_map;
    private Map<Character, Integer> t_map;
    
    
    public boolean isIsomorphic(String s, String t) {
        s_count = 0;
        t_count = 0;
        s_map = new HashMap<>();
        t_map = new HashMap<>();
        return isTwoListAllElementsEqual(buildHashList_s(s), buildHashList_t(t));
    }
    
    private boolean isTwoListAllElementsEqual(List<Integer> a, List<Integer> b){
        for(int i = 0; i < a.size(); i++){
            if(!a.get(i).equals(b.get(i))){
                return false;
            }
        }
        return true;
    }
    
    private List<Integer> buildHashList_s(String s) {
        return s.chars().mapToObj(c -> (char) c)
            .map(c -> s_hash(c))
            .collect(Collectors.toList());
    }
    
    private List<Integer> buildHashList_t(String s) {
        return s.chars().mapToObj(c -> (char) c)
            .map(c -> t_hash(c))
            .collect(Collectors.toList());
    }
    
    private int s_hash(char c){
        if(s_map.containsKey(c)){
            return s_map.get(c);
        } else {
            s_map.put(c, s_count);
            return s_count++;
        }
    }
    
    private int t_hash(char c){
        if(t_map.containsKey(c)){
            return t_map.get(c);
        } else {
            t_map.put(c, t_count);
            return t_count++;
        }

    }
    
    
}