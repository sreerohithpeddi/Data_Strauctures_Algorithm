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
/// TC O(1)
/// SC O(1)