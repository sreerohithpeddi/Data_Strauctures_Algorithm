class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> result = new ArrayList<>(row * col);
        int top = 0;
        int left = 0;
        int bottom = row-1;
        int right = col-1;

        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                result.add(matrix[top][i]);  
            }
            top++;

            for(int i=top;i<=bottom;i++){
                result.add(matrix[i][right]);
                
            }
            right--;

            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    result.add(matrix[i][left]);
                }
                left++;
            } 
        }
        return result;
    }
}

// TC O(n^2) 
// SC O(n^2)

//https://leetcode.com/problems/spiral-matrix/