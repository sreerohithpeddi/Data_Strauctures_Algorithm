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
/// below is bucket approach 
/// TC O(n)
class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        int maxGap = 0;

        if(n<2){
            return 0;
        }

        int min =Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num:nums){
            min = Math.min(num,min);
            max = Math.max(num,max);
        }
        
        int[] minArr = new int[n-1];
        int[] maxArr = new int[n-1];

        Arrays.fill(minArr,Integer.MAX_VALUE);
        Arrays.fill(maxArr,Integer.MIN_VALUE);

        int bucketSize = (int) Math.ceil((double)(max-min)/(n-1));

        for(int i=0;i<n;i++){
            if(nums[i] == max || nums[i]==min) continue;
            int index = (nums[i]-min)/bucketSize;
            minArr[index] = Math.min(minArr[index],nums[i]);
            maxArr[index] = Math.max(maxArr[index],nums[i]);
        }

        for(int i=0;i<n-1;i++){
            if(maxArr[i]==Integer.MIN_VALUE) continue;
            maxGap = Math.max(minArr[i]-min,maxGap);
            min = maxArr[i];
        }

        maxGap = Math.max(max-min,maxGap);
        return maxGap;
    }
}