class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        if(nums.length<2){
            return 0;
        }
        for(int i=0;i<nums.length-1;i++){
            if((nums[i+1] - nums[i])>result){
                result=nums[i+1] - nums[i];
            } 
        }
        return result;
    }
}
// TC O(nlogn) * O(n)                                   Step 5:
// SC O(1)                                              Finally compare the last bucket with the original max.
// try with own sorting technique to reduce complexity  maxGap = max(maxGap, max - previousBucketMax)
/// try with diff approach                              Return maxGap.
/// below is bucket approach                            TC : O(n)
/// TC O(n)                                             SC : O(n)
/// 
/**
 * Intuition:
 *
 * Step 1:                       Step 2:                                Step 3:                                 Step 4:
 * Find the minimum and maximum  Create two bucket arrays.              Place every number into its bucket.     Traverse the buckets.
 *values from the array.                                                Skip min and max because                Skip empty buckets.
 * min = smallest element        minArr[] → Fill with Integer.MAX_VALUE they are used as boundaries.            Gap = CurBucketMin-PrevBucketMax
 * max = largest element         maxArr[] → Fill with Integer.MIN_VALUE bucketIndex = (num - min) / bucketSize  maxGap = max(maxGap, Gap)
 *                               Calculate Bucket Size:                 For every bucket store only:            Update Previous Bucket Max.
 *                             bucketSize=ceil((max - min) / (n - 1))   - Minimum element in MinArray
 * ---------------------------------------------------                  - Maximum element in MaxArray
 */
class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        int maxGap = 0;

        if(n<2){
            return 0;
        }

        int min =Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num:nums){
            min = Math.min(num,min);
            max = Math.max(num,max);
        }
        
        int[] minArr = new int[n-1];
        int[] maxArr = new int[n-1];

        Arrays.fill(minArr,Integer.MAX_VALUE);
        Arrays.fill(maxArr,Integer.MIN_VALUE);

        int bucketSize = (int) Math.ceil((double)(max-min)/(n-1));

        for(int i=0;i<n;i++){
            if(nums[i] == max || nums[i]==min) continue;
            int index = (nums[i]-min)/bucketSize;
            minArr[index] = Math.min(minArr[index],nums[i]);
            maxArr[index] = Math.max(maxArr[index],nums[i]);
        }

        for(int i=0;i<n-1;i++){
            if(maxArr[i]==Integer.MIN_VALUE) continue;
            maxGap = Math.max(minArr[i]-min,maxGap); // getting the maxGap across buckets
            min = maxArr[i]; // modifing the min with max value in last bucket
        }

        maxGap = Math.max(max-min,maxGap);
        return maxGap;
    }
}

/**
 * Input:
 * nums = [23, 7, 49, 35, 18, 3, 27, 41, 12]
 *
 * --------------------------------------------------------
 * Step 1: Find Min & Max
 *
 * min = 3
 * max = 49
 *
 * --------------------------------------------------------
 * Step 2: Create Buckets
 *
 * n = 9
 *
 * bucketSize = ceil((49 - 3) / (9 - 1))
 *            = ceil(46 / 8)
 *            = 6
 *
 * minArr = [INF, INF, INF, INF, INF, INF, INF, INF]
 * maxArr = [-INF,-INF,-INF,-INF,-INF,-INF,-INF,-INF]
 *
 * --------------------------------------------------------
 * Step 3: Place numbers into buckets
 * (Skip min = 3 and max = 49)
 *
 * Number   Bucket Index     Bucket Range
 * ---------------------------------------
 *   7      (7-3)/6  = 0      [3 - 8]
 *  12      (12-3)/6 = 1      [9 -14]
 *  18      (18-3)/6 = 2      [15-20]
 *  23      (23-3)/6 = 3      [21-26]
 *  27      (27-3)/6 = 4      [27-32]
 *  35      (35-3)/6 = 5      [33-38]
 *  41      (41-3)/6 = 6      [39-44]
 *
 * Buckets:
 *
 * Bucket      Min     Max
 * --------------------------
 *   0          7       7
 *   1         12      12
 *   2         18      18
 *   3         23      23
 *   4         27      27
 *   5         35      35
 *   6         41      41
 *   7        INF    -INF
 *
 * --------------------------------------------------------
 * Step 4: Find Maximum Gap
 *
 * previous = min = 3
 *
 * Gap = 7  - 3  = 4
 * previous = 7
 *
 * Gap = 12 - 7  = 5
 * previous = 12
 *
 * Gap = 18 -12  = 6
 * previous = 18
 *
 * Gap = 23 -18  = 5
 * previous = 23
 *
 * Gap = 27 -23  = 4
 * previous = 27
 *
 * Gap = 35 -27  = 8   ← maxGap = 8
 * previous = 35
 *
 * Gap = 41 -35  = 6
 * previous = 41
 *
 * Bucket 7 is empty → Skip
 *
 * --------------------------------------------------------
 * Step 5: Compare with original max
 *
 * Gap = 49 - 41 = 8
 *
 * maxGap = max(8, 8) = 8
 *
 * Output:
 * 8
 *
 * --------------------------------------------------------
 * Intuition:
 *
 * 1. Find the min and max values.
 * 2. Create bucket arrays (minArr & maxArr).
 * 3. Compute the bucket size.
 * 4. Place every number into its bucket (except min & max).
 * 5. Store only the minimum and maximum of each bucket.
 * 6. Traverse the buckets and compare:
 *      Current Bucket Min - Previous Bucket Max.
 * 7. Finally compare the original max with the last bucket's max.
 *
 * Maximum gap is always BETWEEN consecutive non-empty buckets,
 * never INSIDE a bucket.
 *
 * TC : O(n)
 * SC : O(n)
 */