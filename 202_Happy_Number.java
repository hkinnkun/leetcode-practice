class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int result = n;
        do {
            result = getDigits(result).stream().mapToInt(Integer::intValue)
                .reduce(0,
                       (sum, b) -> sum + (int) Math.pow(b, 2));
            
            if(result == 1) {
                return true;
            } else if (set.contains(result)){
                return false;
            } else {
                set.add(result);
            }
        }while(result != 1);
        return false;
    }
    
    private List<Integer> getDigits(int n){
        int[] temp = String.valueOf(n).chars().map(Character::getNumericValue).toArray();
        return Arrays.stream(temp).boxed().toList();
    }
}
