class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean freq[] = new boolean[nums.length];
        func(nums,ds,ans,freq);
        return ans;
    }
    private void func(int nums[], List<Integer> ds, List<List<Integer>> ans, boolean freq[]){
        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!freq[i]){
                freq[i]=true;
                ds.add(nums[i]);
                func(nums,ds,ans,freq);
                ds.remove(ds.size()-1);
                freq[i] = false;
            }
        }
    }
}


// 2nd Approach
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permute(0,nums,ans);
        return ans;
    }
    public void permute(int ind, int nums[], List<List<Integer>> ans){
        if(ind == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=ind;i<nums.length;i++){
            swap(i,ind,nums);
            permute(ind+1,nums,ans);
            swap(i,ind,nums);
        }
    }
    public void swap(int i,int j,int nums[]){
        int t = nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}
