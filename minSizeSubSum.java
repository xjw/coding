import java.util.*;

/**
 * s=7, nums = [2,3,1,2,4,3]
 * return 2 [4,3]
 */

public class MinSizeSubSum {

    public static int minSubArrayLen(int s, int[] nums) {
        int start, sum, minLen;
        start = sum = 0;
        minLen = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (sum >= s) {
                int currentLen = i - start + 1;
                if (currentLen < minLen) {
                    minLen = currentLen;
                }
                sum -= nums[start++];
            }
        }

        return minLen == nums.length? 0: minLen;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
    }
}
