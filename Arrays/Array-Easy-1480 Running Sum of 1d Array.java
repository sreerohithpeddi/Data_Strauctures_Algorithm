class Solution {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            nums[i] = sum;
        }
        return nums;
    }
}
// TC O(n)
// SC O(1)

// prefix sum approach
class Solution {
    public int[] runningSum(int[] nums) {
        for(int i=1;i<nums.length;i++){
            int sum = 0;
            sum = nums[i] + nums[i-1];
            nums[i]=sum;
        }
        return nums;
    }
}