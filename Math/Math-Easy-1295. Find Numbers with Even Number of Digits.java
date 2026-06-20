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
/// TC O(n)
/// SC O(1)
/// 
/// find optimized version in book