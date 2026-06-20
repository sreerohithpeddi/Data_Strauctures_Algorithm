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