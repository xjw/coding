public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> dict = new HashMap<>();
        int[] result = new int[2];
        for (int i=0; i<nums.length; i++) {
            Integer val = dict.get(target-nums[i]);
            if (val != null) {
                result[0] = val;
                result[1] = i+1;
                return result;
            }
            dict.put(nums[i], i+1);
        }
        return result;
    }
}
