class Solution {
    public long maxKelements(int[] nums, int k) {
        long sum =0;
        int n = nums.length;
        while(k>0){
            Arrays.sort(nums);
            sum = sum + nums[n-1] ;
            int temp = nums[n-1];
            nums[n-1] =(int) Math.ceil(temp/3.0);
            k--;
        }
        return sum;
    }
}

// look for explaination in the book - it is just attempted need to optimize
/// Use MaxHeap -- PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b-a); arrange the values in decreasing order
/// Use MaxHeap -- PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> a-b);   arrange the values in ascending order
/// 
/// using decending order arrangement we can get the max value in the queue & make ciel/3 value out of it and push into queue & do this for k times
/// 
/// 
class Solution {
    public long maxKelements(int[] nums, int k) {
        long sum =0;
        int n = nums.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b-a);
        for(int num:nums){
            maxHeap.offer(num); // inserting makes O(nlogn)
        }
        while(k>0){
            int max = maxHeap.poll();
            sum += max;
            maxHeap.offer((int) Math.ceil(max/3.0)); // O(klogn)
            k--;
        }
        return sum;
    }
}