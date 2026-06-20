class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int num:nums){
            int count=0;// count the factors
            int temp =0; // sum it up the factors - number which are pssible factor
            for(int i=1;i<=num;i++){
                if(num%i==0){
                    count++;
                    temp+=i;
                }
                if (count > 4) break;
            }
            if(count ==4){
                sum += temp;
            }
        }
        return sum;

    }
}

/// need to optimize from leetcode solution so then we will read the solution & understand it
/// TC O(n*m)
/// SC O(1)