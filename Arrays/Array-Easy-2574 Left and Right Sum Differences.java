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
// TC O(n)
// SC O(n)
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 0;
        right[n-1] = 0;
        for(int i=1;i<n;i++){
            left[i] = left[i-1]+nums[i-1]; // left[i-1] + nums[i-1] --> 0+10 --> 0-> previous sum + current element
            // filling from left to right
        }
        for(int i=n-2;i>=0;i--){
            right[i]=right[i+1]+nums[i+1];
        }

        for(int i=0;i<n;i++){
            nums[i] = Math.abs(left[i]-right[i]);
        }
        return nums;
    }
}
// TC O(n)
// SC O(1)
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int left = 0;
        int right = 0;

        for(int num:nums){
            right+=num;
        }

        int total =0;

        for(int i=0;i<nums.length;i++){
            int val = nums[i];
            right-=val;
            nums[i] = Math.abs(left-right);
            left+=val;
        }

        return nums;
    }
}