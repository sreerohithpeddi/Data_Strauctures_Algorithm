/**
 * Input:
 * n = 13
 *
 * Binary:
 * 1101
 *
 * Check Last Bit (n & 1)
 *
 * 1101 & 0001 = 1  ✔ count = 1    0110 & 0001 = 0  ✘ count = 1   0011 & 0001 = 1  ✔ count = 2   0001 & 0001 = 1  ✔ count = 3
 *      ↓                                ↓                              ↓                              ↓
 *      >> 1                            >> 1                            >> 1                           >> 1
 *
 * 0000 
 * */
class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while(n!=0){
            if((n&1)==1){
                count++;
            }
            n=n>>1;
        }
        return count;
    }
}