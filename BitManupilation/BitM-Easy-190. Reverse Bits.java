/**
 *                n        n&1     reverseBit           Intuition:
 * ----------------------------------------------       - Take the last bit of n (n & 1).
 * Initial     01010111      -      00000000            - Shift reverseBit left to make space.
 *                                                      - Insert the extracted bit.
 * i = 0       01010111      1      00000001            - Right shift n to process the next bit.
 * i = 1       00101011      1      00000011            - Repeat 32 times (8 here for simplicity).
 * i = 2       00010101      1      00000111
 * i = 3       00001010      0      00001110            Input:   Binary (8-bit):    Reverse Binary:
 * i = 4       00000101      1      00011101            n = 87   01010111           11101010
 * i = 5       00000010      0      00111010
 * i = 6       00000001      1      01110101            Original : 01010111
 * i = 7       00000000      0      11101010            Reversed : 11101010
 *
 * TC : O(32) ≈ O(1)
 * SC : O(1)
 */
class Solution {
    public int reverseBits(int n) {
        int reverseBit = 0;

        for(int i=0;i<32;i++){
            reverseBit<<=1;
           reverseBit |= (n&1);
           n=n>>1;
        }
        return reverseBit;
        
    }
}
