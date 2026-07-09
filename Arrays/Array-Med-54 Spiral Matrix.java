class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        List<Integer> result = new ArrayList<>(row * col);

        // Boundaries of the current unvisited rectangle
        int top = 0, bottom = row - 1;// top - intial row -- bottom - last row
        int left = 0, right = col - 1;// left - intial col -- right - last col

        // Keep shrinking the rectangle until all elements are visited
        // T<=B && L<=R condition
        // L -> R -- top++ -- i++
        // T -> B -- Right -- i++
        // T<=B -- R -> L -- Bottom-- -- i-- -- bottom is shrinking so bottom has condition
        // l<=R -- B -> T -- Left++   -- i-- -- left is shrinking so left has condition
        while (top <= bottom && left <= right) {

            // → Traverse top row, then move top boundary down
            for (int i = left; i <= right; i++)
                result.add(matrix[top][i]);
            top++;

            // ↓ Traverse right column, then move right boundary left
            for (int i = top; i <= bottom; i++)
                result.add(matrix[i][right]);
            right--;

            // ← Traverse bottom row (if it exists), then move bottom up
            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    result.add(matrix[bottom][i]);
                bottom--;
            }

            // ↑ Traverse left column (if it exists), then move left right
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    result.add(matrix[i][left]);
                left++;
            }
        }

        return result;
    }
}

// spiral I is about getting the values from the 2D array to a List
// spiral II is about adding the values into the 2D array

/*
1 -> 2 -> 3
          |
4 -> 5    6
^         |
7 <- 8 <- 9
*/

// TC O(n^2) 
// SC O(n^2)

//https://leetcode.com/problems/spiral-matrix/