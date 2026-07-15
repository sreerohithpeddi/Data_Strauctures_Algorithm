class Solution {
    public int findNumbers(int[] nums) {
        int totalEven = 0;
        for(int num:nums){
            String temp = toString(num);
            if(temp.length()%2==0){
                totalEven++;
            }
        }
        return totalEven;
    }
}
    /// Given an array nums of integers, return how many of them contain an even number of digits.
    /// Input: nums = [555,901,482,1771]
    // Output: 1 Explanation: Only 1771 contains an even number of digits.    
    // Constraints: 
    // 1 <= nums.length <= 500 
    // 1 <= nums[i] <= 105    
class Solution {
    public int findNumbers(int[] nums) {
        int totalEven = 0;
        for(int num:nums){
            if((num>=10 && num<=99) || (num>=1000 && num<=9999) || num==100000){
                totalEven++;
            }
        }
        return totalEven;
    }
}
/// TC O(n)
/// SC O(1)
/// 
/// find optimized version in book