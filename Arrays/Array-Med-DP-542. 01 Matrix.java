class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int max = row+col;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]==0) continue;
                int top = max,left = max;
                if(i>0) top = mat[i-1][j];   
                if(j>0) left = mat[i][j-1];
                mat[i][j] = Math.min(top,left) +1;
            }
        }
        for(int i=row-1;i>=0;i--){
            for(int j=col-1;j>=0;j--){
                
                if(mat[i][j]==0) continue;
                int bottom = max,right = max;
                if(i<row-1) bottom = mat[i+1][j];
                if(j<col-1) right = mat[i][j+1];
                mat[i][j] = Math.min(mat[i][j], Math.min(bottom,right) +1);
                
                
            }
        }
        return mat;
    }
}

// look for explaination in the book - Solved in Dynamic Programming have to solve in Array's