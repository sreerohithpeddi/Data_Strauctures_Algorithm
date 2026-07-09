/**
 * Input Matrix                         Pass 1 (Top → Bottom, Left → Right)      Pass 2 (Bottom → Top, Right → Left)
 *                                      Only use Top & Left neighbours.          Improve distances using Bottom & Right.
 *      c0 c1 c2 c3 c4 c5 c6                c0 c1 c2 c3 c4 c5 c6                    c0 c1 c2 c3 c4 c5 c6
 *                                      /   11 11 11 11 11 11 11
 *      ---------------------               ---------------------                   ---------------------
 * r0 |  1  0  1  1  1  1  1        r0 11 | 12 0  1  2  3  4  5               r0 |  1  0  1  2  3  2  1 |11 
 * r1 |  1  1  1  1  1  1  0        r1 11 | 12 1  2  3  4  5  0               r1 |  2  1  2  1  2  1  0 |11
 * r2 |  1  1  1  0  1  1  1        r2 11 | 12 2  3  0  1  2  1               r2 |  3  2  1  0  1  2  1 |11
 * r3 |  1  1  1  1  1  1  1        r3 11 | 12 3  4  1  2  3  2               r3 |  4  3  2  1  2  3  2 |11
 *                                                                                  --------------------
 *                                                                                  11 11 11 11 11 11 11  /
 *         Formula:                  Pass 1 : min(Top, Left) + 1           Pass 2 : min(Current, min(Bottom, Right) + 1)
 *            
 *  Why 11?
 * max = row + col = 11
 * 11 acts like a temporary "infinity" value until a shorter path is found.
 *
 * Pass 1 spreads distances from Top & Left.
 * Pass 2 corrects them using Bottom & Right.
 * Together, both passes give the shortest distance to the nearest 0.
 */
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