class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtracking(result, "", 0, 0, n);
        return result;
    }
    
    private void backtracking(List<String> result, String s, int openCount, int closeCount, int n) {
        if(openCount == closeCount && openCount == n ) {
            result.add(s);
            return;
        }
        
        if(openCount < n) {
            backtracking(result, s + "(", openCount + 1, closeCount, n);
        }
        if(closeCount < openCount) {
            backtracking(result, s + ")", openCount, closeCount+ 1, n);
        }
    }
}
