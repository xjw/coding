/**
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 * 
 */

/**
 * Solution:
 * There are at most two majority element with count > n/3
 * find the two with more majority 
 * and then verify > n/3
 */
public class MajorityElement {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new LinkedList<Integer>();
        int m1, m2, c1, c2;
        m1 = m2 = c1 = c2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (c1 == 0) {
                m1 = num;
            } else if (c2 == 0) {
                m2 = num;
            }

            if (num == m1) c1++;
            else if (num == m2) c2++;
            else {
                c1--;
                c2--;
            }
        }
        
        c1 = c2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == m1) c1++;
            else if (nums[i] == m2) c2++;
        }
        if (c1 > nums.length / 3) result.add(m1);
        if (c2 > nums.length / 3) result.add(m2);
        return result;
    }
}

