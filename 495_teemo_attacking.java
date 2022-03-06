class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result=0;
        for(int i = 0; i < timeSeries.length; i++){
            if(i!=0){
                if(timeSeries[i] - timeSeries[i-1] <= duration){
                    result = result - duration + (timeSeries[i] - timeSeries[i-1]);
                }
            }
            result+=duration;
        }
        return result;
    }
    
}