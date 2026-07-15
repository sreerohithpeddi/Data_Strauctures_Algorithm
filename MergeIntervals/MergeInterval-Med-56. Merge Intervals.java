/**
 * Input:
 *
 * [1,3]  [2,6]  [8,10]  [15,18]
 *
 * Step 1: Sort by start time
 *
 * [1,3]  [2,6]  [8,10]  [15,18]
 *
 * Step 2: Merge
 *
 * [1,3]
 *    [2,6]
 * ----------- Merge ----------> [1,6]
 *
 * [1,6]   [8,10]   [15,18]
 *
 * No overlap with [8,10]
 * Add it.
 *
 * No overlap with [15,18]
 * Add it.
 *
 * Result:
 * [1,6] [8,10] [15,18]
 *
 * Overlap Condition:
 * currentStart <= previousEnd
 *
 * Merge:
 * previousEnd = max(previousEnd, currentEnd)
 *
 * TC : O(n log n)   // Sorting
 * SC : O(n)
 */

class Solution {
    public int[][] merge(int[][] intervals) {

        int size = intervals.length;
        Arrays.sort(intervals , (a,b)-> Integer.compare(a[0],b[0]));
        List<int[]> ans = new ArrayList<>();
        int[] prev = intervals[0];

        for(int i=1;i<size;i++){
            int[] interval= intervals[i];
            if(interval[0] <= prev[1]){
                prev[1] = Math.max(interval[1],prev[1]);
            }else{
                ans.add(prev);
                prev = interval;
            }
        }

        ans.add(prev);

        return ans.toArray(new int[ans.size()][]);
    }
}