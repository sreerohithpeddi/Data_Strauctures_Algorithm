/**
 * Input:
 * n = 7
 *
 * Teams      Matches      Teams Left
 * ----------------------------------
 *   7           3             4
 *   4           2             2
 *   2           1             1
 *
 * Total Matches = 3 + 2 + 1 = 6
 *
 * Every Round:
 * matches += n / 2
 * teams = n / 2 + n % 2
 *
 * Stop when only one team remains.
 *
 * TC : O(log n)
 * SC : O(1)
 */
class Solution {
    public int numberOfMatches(int n) {
        return n-1;
    }
}

class Solution {
    public int numberOfMatches(int n) {

        int matches = 0;

        while (n > 1) {

            matches += n / 2;

            n = n / 2 + n % 2;
        }

        return matches;
    }
}

// need to explain the approach