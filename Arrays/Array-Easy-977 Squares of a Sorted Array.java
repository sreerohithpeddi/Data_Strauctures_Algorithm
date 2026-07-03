class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int[] sqArr = new int[n];
        for(int i=0;i<n;i++){
            int leftsQ = nums[i] * nums[i];
            int rightsQ = nums[n-1-i] * nums[n-1-i];
            if(leftsQ > rightsQ){
                sqArr[n-1-i] = leftsQ;
                left++;
            }else{
                sqArr[n-1-i] = rightsQ;
                right--;
            }
        }
        return sqArr;
    }
}
// Input: nums = [-4,-1,0,3,10] --> square the elements [16,1,0,9,100] --> sort all element --> [0,1,9,16,100]
// Output: [0,1,9,16,100]
// Explanation: After squaring, the leftEnd and rightEnd element of an Array
//              find out max value & filling in the new Array from right to left by comparig them & changing the index of left & right according to max
// becomes [16,1,0,9,100].
// After sorting, it becomes [0,1,9,16,100].
// filling larger number at the end - nums go's with decreasing order

// TC O(n)
// SC O(n)
// Two Pointer Approach