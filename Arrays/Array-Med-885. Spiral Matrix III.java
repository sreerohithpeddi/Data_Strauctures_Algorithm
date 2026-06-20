class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

        int dir[][] = {
            {0,1},{1,0},{0,-1},{-1,0}
        };

        int n=rows*cols;
        int result[][] = new int[n][2];
        result[0][0] = rStart;
        result[0][1] = cStart;
        int index =0; // 0,1,2,3 - directions % 4
        int count=1;
        int steps = 1; // every 2 times steps increase by 1

        while(count<n){
            for(int times=0;times<2;times++){
                int dr = dir[index%4][0];
                int dc = dir[index%4][1];
                for(int i=0;i<steps;i++){
                    rStart += dr;
                    cStart += dc;
                    if( 0<=rStart && rStart<rows && 0<=cStart && cStart<cols ){
                        result[count][0] = rStart;
                        result[count][1] = cStart;
                        count++;
                    }
                }
                index++;
            }
            steps++;
        }

        return result;
        
    }
}
// get book visuals