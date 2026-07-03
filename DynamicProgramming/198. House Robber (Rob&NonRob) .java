class Solution {
    public int rob(int[] nums) {

        if(nums.length<2){
            return nums[0];
        }

        int[] result = new int[nums.length];

        result[0] = nums[0];
        result[1] = Math.max(nums[0],nums[1]);

        for(int i=2;i<nums.length;i++){
            int stealCurrent = result[i-2];
            int notStealCurrent = result[i-1];
            result[i] = Math.max(stealCurrent+nums[i] , notStealCurrent);
        }

        return result[nums.length-1];
    }
}
///  it will automatically contact the police if two adjacent houses were broken into on the same night.
///  Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
/// TC O(n)
/// SC O(n)
// get book visuals
/// TC O(n)
/// SC O(1)
/// [2,7,3,8,4,2,1,8] use this input
class Solution {
    public int rob(int[] nums) {

        if(nums.length<2){
            return nums[0];
        }

        int rob1 = nums[0];
        int rob2 = Math.max(nums[0],nums[1]);

        for(int i=2;i<nums.length;i++){
            int temp = Math.max(rob1+nums[i],rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }
}