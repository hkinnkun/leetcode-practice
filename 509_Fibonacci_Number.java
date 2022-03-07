class Solution {
    
    public int fib(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        int fn_2 = 0;    
        int fn_1 = 1;
        int fn = fn_2 + fn_1;
        for(int i = 3; i <=n ;i++){
            fn_2 = fn_1;
            fn_1 = fn;
            fn = fn_2 + fn_1;
        }
        return fn;
        
    }
}
