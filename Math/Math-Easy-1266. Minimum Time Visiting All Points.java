/**
 * Input:
 * points = [[1,1], [3,4], [-1,0]]
 *
 * y                                    Visit Order:                (1,1) → (3,4)                    (3,4) → (-1,0)
 * 4 |                 ● (3,4)          (1,1) → (3,4) → (-1,0)      dx = 3-1 = 2, dy = 4-1 = 3       dx = 4, dy = 4
 * 3 |                                                              Time = max(2,3) = 3              Time = max(4,4) = 4
 * 2 |
 * 1 |         ● (1,1)                                              Total Time = 3 + 4 = 7
 * 0 | ● (-1,0)                                                     Formula:
 *   +------------------------> x                                   Time = max(abs(dx1 - dx2), abs(dy1 - dy2))
 *     -1   0   1   2   3                                                          
 *
 * TC : O(n)
 * SC : O(1)
 * 
 */
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for(int i=1;i<points.length;i++){
            ans += Math.max( 
                Math.abs( points[i][1] - points[i-1][1] ) , 
                Math.abs( points[i][0] - points[i-1][0] ) 
            );
        }
        return ans;
    }
}

/// TC O(n)
/// SC O(1)
/// 