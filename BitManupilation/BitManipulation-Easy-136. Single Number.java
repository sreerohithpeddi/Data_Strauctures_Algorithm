// Recap of Bit Manipulation
/// x & 0 = 0       x & x = x
/// x | 0 = 0       x | x = x
/// x ^ 0 = x       x ^ x = 0
/**
 * nums = [2, 2, 4]
 *
 * result = 0
 *
 * 0000 ^ 0010 = 0010 (2)
 * 0010 ^ 0010 = 0000 (0)
 * 0000 ^ 0100 = 0100 (4)
 *
 * Answer = 4
 *
 * Intuition:
 * Same numbers cancel each other.
 *
 
 */

class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int num:nums){
            result = result^num;
        }
        return result;
    }
}
// TC O(n)
// SC O(1)
// check diff approach