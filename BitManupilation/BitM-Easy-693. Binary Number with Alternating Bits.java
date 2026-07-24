/**
 * Example:
 * n = 10
 *
 * Binary            Operation
 * ----------------------------------------
 * 1010              n
 * 0101              n >> 1
 * ----
 * 1111              a = n ^ (n >> 1)
 *
 * 1111              a
 *10000              a + 1
 *-----
 *00000              a & (a + 1) == 0 ✔
 *
 * Answer = true
 *
 * Intuition:
 * n ^ (n >> 1) → All 1's if bits alternate.  
 * (a & (a + 1)) == 0 → Checks if a is all 1's.
 *
 * TC : O(1)
 * SC : O(1)
 */
class Solution {
    public boolean hasAlternatingBits(int n) {
        int a = n^(n>>1);
        return (a&(a+1)) ==0;
    }
}

/// TC O(1)
/// SC O(1)