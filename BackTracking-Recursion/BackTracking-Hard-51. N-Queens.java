class Solution {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList();

        char[][] board = new char[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }

        helper(result,board,0);

        return result;
        
    }

    private void helper(List<List<String>> result,char[][] board,int row){
        int n = board.length;
        if(row==n){
            List<String> temp = new ArrayList<>();

            for (char[] rowArray : board) {
                temp.add(new String(rowArray));
            }

            result.add(temp);
            return;
        }
        for(int col=0;col<n;col++){
            if(isSafe(board,row,col)){
                board[row][col] = 'Q';
                helper(result,board,row+1); 
                board[row][col] = '.';
            }
        }
    }


    private boolean isSafe(char[][] board,int row,int col){
        int n = board.length;

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
         for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}