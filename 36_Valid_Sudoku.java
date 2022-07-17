class Solution {
    public boolean isValidSudoku(char[][] board) {
        //for each row
        for (int i = 0; i < board.length; i++){
            if(!validate(board[i])) return false;
        }
        //for each column
        for(int i = 0; i < 9; i++){
            char[] column = new char[9];
            column[0] = board[0][i];
            column[1] = board[1][i];
            column[2] = board[2][i];
            column[3] = board[3][i];
            column[4] = board[4][i];
            column[5] = board[5][i];
            column[6] = board[6][i];
            column[7] = board[7][i];
            column[8] = board[8][i];
            if(!validate(column)) return false;
        }
        //for each 3*3 box
        for(int i = 0; i < 9; i=i+3) {
            
            char[] box = new char[9];
            
            box[0] = board[i][0];
            box[1] = board[i+1][0];
            box[2] = board[i+2][0];
            box[3] = board[i][1];
            box[4] = board[i+1][1];
            box[5] = board[i+2][1];
            box[6] = board[i][2];
            box[7] = board[i+1][2];
            box[8] = board[i+2][2];

            if(!validate(box)) return false;
            
            
            box[0] = board[i][3];
            box[1] = board[i+1][3];
            box[2] = board[i+2][3];
            box[3] = board[i][4];
            box[4] = board[i+1][4];
            box[5] = board[i+2][4];
            box[6] = board[i][5];
            box[7] = board[i+1][5];
            box[8] = board[i+2][5];

            if(!validate(box)) return false;
            box[0] = board[i][6];
            box[1] = board[i+1][6];
            box[2] = board[i+2][6];
            box[3] = board[i][7];
            box[4] = board[i+1][7];
            box[5] = board[i+2][7];
            box[6] = board[i][8];
            box[7] = board[i+1][8];
            box[8] = board[i+2][8];

            if(!validate(box)) return false;
            
        }
        return true;
    }
    
    private boolean validate(char[] each){
        //System.out.println("Validating:"+Arrays.toString(each));
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < each.length; i++){
            if(each[i] == '.') continue;
            if(set.contains(each[i])) return false;
            set.add(each[i]);
        }
        return true;
    }
}
