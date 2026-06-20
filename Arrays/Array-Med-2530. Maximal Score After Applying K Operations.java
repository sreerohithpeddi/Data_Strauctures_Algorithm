class Solution {
    public long maxKelements(int[] nums, int k) {
        long sum =0;
        int n = nums.length;
        while(k>0){
            Arrays.sort(nums);
            sum = sum + nums[n-1] ;
            int temp = nums[n-1];
            nums[n-1] =(int) Math.ceil(temp/3.0);
            k--;
        }
        return sum;
    }
}

// look for explaination in the book - it is just attempted need to optimize