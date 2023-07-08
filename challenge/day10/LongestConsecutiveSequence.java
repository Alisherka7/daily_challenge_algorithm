class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for(int num : nums){
            set.add(num);
        }
        int res = 1;
        for(int num : nums){
            if(!set.contains(num-1)){
                int count = 1;
                while(set.contains(num+1)){
                    num++;
                    count++;
                }
                res = count > res ? count : res;
            }
        }
        return res;
    }
}
