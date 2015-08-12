/**
 * https://leetcode.com/problems/house-robber/
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */ 

public class HouseRobber {

    public int robRecursiveWithCaching(int start, int[] nums, Map<Integer, Integer> cache) {
        if (start >= nums.length) return 0;
        if (cache.containsKey(start)) return cache.get(start);
        int res = Math.max(nums[start] + rob(start+2, nums), rob(start+1, nums), cache);
        cache.put(start, res);
        return res;
    }

    public int robDP(int[] nums) {
        int len = nums.length;
        int[] maxRob = new int[len+2];
        int pre = 0;
        int cur = nums[len-1];
        for (int i = len-1; i>=0; i--) {
            maxRob[i] = Math.max(nums[i] + maxRob[i+2], maxRob[i+1]);
        }
        return maxRob[0];
    }

    /**
     * From code above, it's clear only current and previous max are needed
     * so no need to use array for caching
     */ 
    public int robDPConstantSpace(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;
        int pre, cur;
        pre = 0;
        cur = nums[0];
        for (int i = 1; i < len; i++) {
            int tmp = cur;
            cur = Math.max(nums[i] + pre, cur);
            pre = tmp;
        }
        return cur;
    }

}
