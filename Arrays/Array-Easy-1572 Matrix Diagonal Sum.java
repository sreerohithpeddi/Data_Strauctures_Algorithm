class Solution {
    public int diagonalSum(int[][] mat) {

        int sum = 0;

        for(int i=0;i<mat[0].length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(i==j || i+j == mat[0].length-1){
                    sum += mat[i][j];
                }
            }
        }
        return sum;
    }
}

// above TC O(n^2) SC O(1)

// below TC O(n) SC O(1)

class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat[0].length;
        for(int i=0;i<n;i++){
            sum += mat[i][i];
            if(i!=n-1-i){  // avoiding common values between mat[i][j] & mat[i][n-1-i]
                sum += mat[i][n-1-i];
            }
        }
        return sum;
    }
}