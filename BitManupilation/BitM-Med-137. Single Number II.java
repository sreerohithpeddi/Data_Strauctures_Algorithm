class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int bit=0 ; bit < 32 ; bit++){
            int count = 0 ;
            for(int i=0; i<nums.length ;i++){
                if((nums[i] & (1<< bit)) != 0){
                    count++;
                }
            }

            if(count % 3 !=0){
                result = result | 1<<bit;
            }
        }

        return result;
        
    }
}

/// TC O(1)+O(n)
/// SC O(1)