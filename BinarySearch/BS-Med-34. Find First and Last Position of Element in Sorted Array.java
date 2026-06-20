class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{firstAndLastOccurance(nums,target,true),firstAndLastOccurance(nums,target,false)};
    }

    int firstAndLastOccurance(int[] arr,int t,boolean flag){
        int l=0;
        int r=arr.length-1;
        int ans = -1;
        
        while (l<=r){
            int m = l+((r-l)/2);

            if(arr[m]>t){
                r=m-1;  
            }else if(arr[m]<t){
                l=m+1;  
            }else {
                ans = m;
                if(flag){
                    r=m-1; // first occurance
                }else{
                    l=m+1;
                }
            }
        }
        return ans;
    }

    
}

///
/// Time Complexity	O(log n)
// Space Complexity	O(1)
/// have to check why BS TC is nlogn