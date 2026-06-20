class Solution {
    public int findPairs(int[] nums, int k) {
        int left = 0;
        int right = 1;
        int count = 0;
        Arrays.sort(nums);
        while(left< nums.length && right<nums.length){
            int diff = nums[right]-nums[left];
            if(diff>k){
                left++;
            }else if(diff<k){
                right++;
            }else if(left==right){
                right++;
            } 
            else{
                count++;
                left++;
                right++;
                while(right<nums.length && nums[right]==nums[right-1]){
                    right++;// after finding pair move to another pair
                }
            }
        }
        return count;
    }
}