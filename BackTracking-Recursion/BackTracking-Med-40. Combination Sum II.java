class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates,target,result,new ArrayList<>(),0);
        return result;
        
    }

    private void helper(int[] candidates,int target,List<List<Integer>> result,List<Integer> current,int index){
        if(target==0){
            result.add(new ArrayList<>(current));
            return;
        }
        if(target<0) return;

        for(int i=index;i<candidates.length;i++){
            if(i>index && candidates[i] == candidates[i-1]) continue;
            current.add(candidates[i]);
            helper(candidates,target-candidates[i],result,current,i+1);
            current.remove(current.size()-1);
        }
        
    }
}