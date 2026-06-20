class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];

        int top = 0;
        int left = 0;
        int bottom = n-1;
        int right = n-1;

        int count = 1;
        while(top<=bottom && left<=right){

            for(int i=left;i<=right;i++){
                ans[top][i] = count;
                count++;
            }
            top++;

            for(int i=top;i<=bottom;i++){
                ans[i][right] = count;
                count++;
            }
            right--;

            for(int i=right;i>=left;i--){
                ans[bottom][i] = count;
                count++;
            }
            bottom--;

            for(int i=bottom;i>=top;i--){
                ans[i][left] = count;
                count++;
            }
            left++;
        }
        return ans;
    }
}

// TC O(n^2) 
// SC O(n^2)

//https://leetcode.com/problems/spiral-matrix-ii/