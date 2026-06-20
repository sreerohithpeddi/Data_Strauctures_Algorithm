class Solution {
    public boolean hasAlternatingBits(int n) {
        int a = n^(n>>1);
        return (a&(a+1)) ==0;
    }
}

/// TC O(1)
/// SC O(1)