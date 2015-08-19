public class MajorityElement {
    public int majorityElement(int[] nums) {
        int result = nums[0];
        int count = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == result || count ==0) {
                result = nums[i];
                count++;
            }
            else count--;
        }
        return result;
    }
}
