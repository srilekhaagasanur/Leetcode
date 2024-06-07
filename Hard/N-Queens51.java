class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        int[] leftRow = new int[n];
        int[] upperDiag = new int[2 * n - 1];
        int[] lowerDiag = new int[2 * n - 1];
        func(0,board,ans,leftRow,upperDiag,lowerDiag,n);
        return ans;
    }
    public void func(int col, char[][] board, List<List<String>> ans, int leftRow[], int upperDiag[], int lowerDiag[], int n){
        if(col == n){
            ans.add(construct(board));
            return;
        }
        for(int row=0;row<n;row++){
            if(leftRow[row]==0 && lowerDiag[row+col]==0
            && upperDiag[n-1+col-row]==0){
                board[row][col] = 'Q';
                leftRow[row]=1;
                lowerDiag[row+col]=1;
                upperDiag[n-1+col-row]=1;
                func(col+1,board,ans,leftRow,upperDiag,lowerDiag,n);
                board[row][col]='.';
                leftRow[row]=0;
                lowerDiag[row+col]=0;
                upperDiag[n-1+col-row]=0;
            }
        }
    }
    public List<String> construct(char[][] board){
        List<String> res = new ArrayList<>();
        for(int i=0; i<board.length; i++){
            res.add(new String(board[i]));
        }
        return res;
    }
}
