class Solution {
    
    public class TempAndIndex {
        int temperature;
        int index;
        
        public TempAndIndex(int temperature, int index){
            this.temperature = temperature;
            this.index = index;
        }
        
        public String toString(){
            return "[temp:"+temperature+", index:"+index+"]";
        }
        
    }
    
    //*** PriorityQueue, iterator does not follow the sorting order as it is implemented by heap
    //** to get the order, need to poll or peek
    //https://stackoverflow.com/questions/5695017/priorityqueue-not-sorting-on-add
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        PriorityQueue<TempAndIndex> q = new PriorityQueue<>(10, (a,b) ->  a.temperature - b.temperature); //acsending order
        
        int[] result = new int[n];
        for(int i = 0 ; i < n; i++) {
            int curTemp = temperatures[i];
            while(q.peek() != null && q.peek().temperature < curTemp) {
                //System.out.println("Queue:"+q.toString() + " q.peek():"+q.peek().temperature + " curTemp:"+curTemp + " i:"+i);
                TempAndIndex found = q.poll();
                result[found.index] = i - found.index;
            }
            q.add(new TempAndIndex(curTemp, i));

        }
        return result;
    }
    
}
