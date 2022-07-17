class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix[0].length;
        //each row
        for(int i = 0 ; i < n ; i ++) {
            if(!validate(matrix[i], n)) return false;
        }
        //each column
        for(int i = 0 ; i < n ; i ++) {
            int[] arr = new int[n];
            for(int j=0 ; j < n; j++) {
                arr[j] = matrix[j][i];
            }
            if(!validate(arr, n)) return false;
        }
        return true;
    }
    
    private boolean validate(int[] arr, int n){
        //System.out.println("Validate:"+ Arrays.toString(arr));
        int[] bucket = new int[n];
        for(int i = 0 ; i < n; i++){
            bucket[arr[i]-1]++;
        }
        boolean result = true;
        for(int i = 0 ; i < n; i++){
            if(bucket[i] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }
}




class Solution {
    public boolean checkValid(int[][] matrix) {
        PriorityQueue<Integer> row = new PriorityQueue<>();
        PriorityQueue<Integer> col = new PriorityQueue<>();
        for(int i = 0 ; i < matrix.length ; i ++) {
            for(int j = 0; j < matrix.length; j++) {
                row.add(matrix[i][j]);
                col.add(matrix[j][i]);
            }
            if(!validate(row) || !validate(col)){
                return false;
            }
        }
        return true;
    }
    
    private boolean validate(PriorityQueue<Integer> p){
        int count = 1;
        while(!p.isEmpty()) {
            if(p.peek() != count) return false;
            count++;
            p.remove();
        }
        return true;
    }

}
