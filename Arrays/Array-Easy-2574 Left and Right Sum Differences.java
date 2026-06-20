class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] sumDiff = new int[nums.length];
        for (int i=0;i<nums.length;i++){
            int leftSum = 0;
            int rightSum = 0;
            for (int j=0;j<i;j++){
                leftSum =leftSum+ nums[j];     
            }
            for (int j=i+1;j<nums.length;j++){
                rightSum =rightSum+ nums[j];
            }
            sumDiff[i] = Math.abs(leftSum - rightSum);
        }
        return sumDiff;
    }
}

// TC O(n^2)
// SC O(n)

// Need to optimize & add their link and approaches and sudo code & any visualization ideas & input & outputs