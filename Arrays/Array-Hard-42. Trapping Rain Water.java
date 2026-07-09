class Solution {
    public int trap(int[] height) {
        int water = 0;
        for(int i=0;i<height.length;i++){
            int leftMax = 0;// for every element we are finding leftMax & rightMax
            int rightMax = 0;
            for(int j=0;j<i;j++){
                leftMax = Math.max(height[j],leftMax);
            }
            for(int k=i;k<height.length;k++){
                rightMax = Math.max(rightMax,height[k]);
            }
            water += Math.min(leftMax,rightMax) - height[i];
        }
        return water;
    }
}// all test cases are not passing  TC O(n^2) SC O(1)
/**
 * Height     :  4  2  0  3  2  5
 *
 * leftMax    :  4  4  4  4  4  5
 * rightMax   :  5  5  5  5  5  5
 * water      :  0  2  4  1  2  0
 *
 * water[i] = min(leftMax[i], rightMax[i]) - current[i]
 *
 * Pass 1 : Store tallest wall from LEFT.
 * Pass 2 : Store tallest wall from RIGHT.
 * Pass 3 : Smaller wall decides water level.
 */
/// TC O(n) SC O(n)
class Solution {
    public int trap(int[] height) {
        int water = 0;
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];
        for(int j=1;j<n;j++){
            leftMax[j] = Math.max(leftMax[j-1], height[j]);
        }
        for(int k=n-2;k>=0;k--){
            rightMax[k] = Math.max(rightMax[k+1], height[k]);
        }
        for(int i=0;i<height.length;i++){
            water += Math.min(leftMax[i],rightMax[i]) - height[i];
        }
        return water;
    }
}
/**
 * Height :   4  2  0  3  2  5
 *            ↑              ↑
 *            l              r
 *
 * lMax = tallest wall from Left.
 * rMax = tallest wall from Right.
 *
 * If (lMax < rMax)
 *   → Left wall limits the water.
 *   → water += lMax - height[l]
 *   → l++
 *
 * Else
 *   → Right wall limits the water.
 *   → water += rMax - height[r]
 *   → r--
 *
 * Smaller wall decides the water level.
 *
 * Time  : O(n)
 * Space : O(1)
 */
class Solution {
    public int trap(int[] height) {
        int water = 0;
        int n = height.length;
        int l=0;
        int r = n-1;
        int lmax = 0;
        int rmax = 0;
        while(l<r){
            lmax = Math.max(lmax,height[l]);
            rmax = Math.max(rmax,height[r]);

            if(lmax<rmax){
                water += lmax - height[l];
                l++;
            }else{
                water += rmax - height[r];
                r--;
            }
        }

        return water;
        
    }
}

