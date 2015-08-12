/**
 * https://leetcode.com/problems/house-robber-ii/
 *
 * Note: This is an extension of House Robber.
After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */ 


/**
 * Solution:
 * The only difference with HouseRobber is instead of list, it's a circle now
 * For a circle, if head/first is chosen, tail/last can not be robbed(neighbor)
 * But it really does not matter where head is, pick any random starting point should end up with same result
 *
 * What matters is once start point is chosen, tail has be to skipped, otherwise, tail can be chosen (2 options)
 * For simplicity we can just choose index 0 as starting point
 */

public class HouseRobberII {
    public int rob(int[] nums) {
        return Math.max(rob(nums, true), rob(nums, false));
    }    

    public int rob(int[] nums, boolean robFirst) {
        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;
        int pre, cur;
        pre = 0;
        if (robFirst) {
            cur = nums[0];
            len--;
        } else {
            cur = 0;
        }
        for (int i = 1; i < len; i++) {
            int tmp = cur;
            cur = Math.max(nums[i] + pre, cur);
            pre = tmp;
        }
        return cur;
    }
}
