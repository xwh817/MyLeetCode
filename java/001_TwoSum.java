class Solution {
    
    // brute force暴力破解
    public int[] twoSumBruteForce(int[] nums, int target) {
        for(int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    
    // 使用Map记录配对元素的下标，遍历两趟
    public int[] twoSumByMap(int[] nums, int target) {
        Map<Integer, Integer> mapper = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++) {
            mapper.put(target - nums[i], i);
        }        
        
        for(int i=0; i<nums.length-1; i++) {
            if (mapper.get(nums[i]) != null) {
                int j = mapper.get(nums[i]);
                if(i != j) {    // 每个元素只能用一次
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    
        
    // 使用Map记录配对元素的下标，遍历一趟
    public int[] twoSumByMap2(int[] nums, int target) {
        Map<Integer, Integer> mapper = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++) {
            if (mapper.containsKey(nums[i])) {
                int j = mapper.get(nums[i]);
                if(i != j) {    // 每个元素只能用一次
                    return new int[]{i, j};
                }
            }
            mapper.put(target - nums[i], i);
        }        
        return null;
    }
    
    public int[] twoSum(int[] nums, int target) {
        return this.twoSumByMap2(nums, target);
    }
    
}