class Solution {
    //[100,4,200,1,3,2]
    //we put all nums into a set
    //answer is [1,2,3,4]
    //since checking 2,3,4 are meaning less
    //we first check if exists num + 1 in the array, then put num+1 in the set, then exclude it when we check the longest consecutive sequence.
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        int result = 0;
        Set<Integer> setForNumMaybeIncludedInLongestConsecutiveSequence = new HashSet<>();
        for(int num: nums) {
            if(set.contains(num+1)) {
                setForNumMaybeIncludedInLongestConsecutiveSequence.add(num+1);
            }
        }
        
        for(int num: nums) {
            if(!setForNumMaybeIncludedInLongestConsecutiveSequence.contains(num)) {
                int curNum = num;
                int currentStreak = 1;
                while(set.contains(curNum + 1)) {
                    curNum++;
                    currentStreak++;
                }
                result = Math.max(currentStreak, result);
            }
        }
        
        return result;
    }
}


class Solution {
    //[100,4,200,1,3,2]
    //we put all nums into a set
    //answer is [1,2,3,4]
    //since checking 2,3,4 are meaning less
    //we first check if exists num - 1 in the array, we check the longest consecutive sequence for not exist.
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        int result = 0;
        
        for(int num: nums) {
            if(!set.contains(num - 1)) {
                int curNum = num;
                int currentStreak = 1;
                while(set.contains(curNum + 1)) {
                    curNum++;
                    currentStreak++;
                }
                result = Math.max(currentStreak, result);
            }
        }
        
        return result;
    }
}
