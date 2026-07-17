/**
 * Input:
 * nums = [2, 10, 12, 1, 11]
 *
 * Virtual Doubled Array (using i % n):
 *
 *          First Pass              Second Pass
 *        (Prepare Stack)          (Fill Result)
 *
 * Index :  9  8  7  6  5 | 4  3  2  1  0
 * Value : 11  1 12 10  2 |11  1 12 10  2
 *                         ↑
 *                     Fill result[]
 *                     (i < n)
 *
 * Result Index :          4  3  2  1  0
 * Result Value :         12 11 -1 12 10
 *
 * Intuition:
 * - Imagine the array is doubled to simulate circular traversal.
 * - Traverse the virtual array from Right → Left.
 * - First pass (indices 9 → 5): prepares the stack.
 * - Second pass (indices 4 → 0): fills result[] from Right → Left.
 * - Use i % n to access the original array without creating a new array.
 *
 * Output:
 * [10, 12, -1, 11, 12]
 */

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>(); 
        // Iterate from right to left across a logical array of length 2*n
        for (int i = 2*n - 1; i >= 0; i--) {
            int current = nums[i % n];
            // Pop all elements that are <= current, because they can't be next greater
            while (!st.isEmpty() && st.peek() <= current) {
                st.pop();
            }
            // Only fill results when i < n (first pass for original positions)
            if(i<n){
                if(st.isEmpty()) result[i] = -1;
                else result[i] = st.peek();
                // result[i] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(current);
        }
        return result;
        
    }
}