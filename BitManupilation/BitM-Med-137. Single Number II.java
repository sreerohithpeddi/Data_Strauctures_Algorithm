/**Input:
 * nums = [2, 2, 2, 3]
 * Binary:
 * 2 = 0010
 * 3 = 0011
 *           Bit Count                  count % 3               Intuition:
 * --------------------------------     ----------------        - Check one bit position at a time (0 to 31).
 * Bit 0 :   0 0 0 1  -> count = 1      Bit 0 : 1 % 3 = 1 ✔    - Count how many numbers have that bit set.
 * Bit 1 :   1 1 1 1  -> count = 4      Bit 1 : 4 % 3 = 1 ✔    - Numbers appearing 3 times contribute multiples of 3.
 * Bit 2 :   0 0 0 0  -> count = 0      Bit 2 : 0 % 3 = 0 ✘    - count % 3 removes those repeated numbers.
 * Bit 3 :   0 0 0 0  -> count = 0      Bit 3 : 0 % 3 = 0 ✘    - If remainder != 0, that bit belongs to the single number.
 *                                                              - Set that bit in the result.
 * Result:
 * 0011 = 3
 * ---------------------------------------
 * TC : O(32 × n) ≈ O(n)
 * SC : O(1)
 */
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int bit=0 ; bit < 32 ; bit++){
            int count = 0 ;
            for(int i=0; i<nums.length ;i++){
                if((nums[i] & (1<< bit)) != 0){ /// for every bit out of 32 bits making count on set bits
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