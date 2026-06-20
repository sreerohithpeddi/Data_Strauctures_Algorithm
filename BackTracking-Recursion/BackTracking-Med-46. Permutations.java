class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
        boolean[] visited = new boolean[n];
        List<List<Integer>> result = new ArrayList();
        List<Integer> current = new ArrayList();
        permutation(visited,current,nums,n,result);
        return result;
    }
    private void permutation(boolean[] visited,List<Integer> current, int[] nums,int n,List<List<Integer>> result){
        if(current.size()==n){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                current.add(nums[i]);
                permutation(visited,current,nums,n,result);
                current.remove(current.size()-1);
                visited[i] = false;
            }
        }
    }
}