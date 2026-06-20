class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        if(nums.length<2){
            return 0;
        }
        for(int i=0;i<nums.length-1;i++){
            if((nums[i+1] - nums[i])>result){
                result=nums[i+1] - nums[i];
            } 
        }
        return result;
    }
}
// TC O(nlogn) * O(n) 
// SC O(1)
// try with own sorting technique to reduce complexity 
/// try with diff approach