/**
 * Input:
 * nums = [1, 2, 3]
 *
 * n = 3
 * Total Subsets = 2^3 = 8
 *
 * BitMask     Set Bits      Subset         Intuition:
 * ------------------------------------     - Iterate from 0 to (2^n - 1).
 * 000         -             {}             - Every number acts as a BitMask. 
 * 001         0             {1}            - Check each bit from right to left.    
 * 010         1             {2}            - If the bit is set (1), include nums[j].
 * 011         0,1           {1,2}          - If the bit is not set (0), skip nums[j].
 * 100         2             {3}            - The selected elements form one subset.
 * 101         0,2           {1,3}          - Find the XOR of that subset and add it to the answer.
 * 110         1,2           {2,3}          TC : O(n × 2^n)
 * 111         0,1,2         {1,2,3}        SC : O(1)
 *
 */
class Solution {
    public int subsetXORSum(int[] nums) {
        int sum = 0;
        for(int i=0;i<1<<nums.length;i++){
            int sumOfSubset = 0;
            for(int j=0;j<nums.length;j++){
                if((i&(1<<j))!=0){
                    sumOfSubset = sumOfSubset ^ nums[j];
                }
            }
            sum += sumOfSubset;
        }
        return sum;
    }
}
// TC O(2^n) + O(n)
// SC O(1)