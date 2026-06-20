class Solution {
    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];

        for(int i=0;i<n;i++){
            arr[0][i] = 1; 
        }
        
        for(int i=0;i<m;i++){
            arr[i][0] = 1; 
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        return arr[m-1][n-1];
    }
}

/// TC O(m*n)
/// SC O(m*n)
/// 
/// [1,1,1,1,1]
/// [1,2,3,4,5]
/// [1,3,6,10,15] 
/// 15 unique ways
/// filling first row & col with 1 & assigning current element with arr[i-1][j] + arr[i][j-1]
/// return last element value to get total no of unique ways to reach from left-top to right-bottom
/// https://leetcode.com/problems/unique-paths/