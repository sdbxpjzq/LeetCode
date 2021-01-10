package _01_数组._27_移除元素_简单;

public class Solution_1 {
    public int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                fast++;
                slow++;
            }else {
                fast++;
            }
        }
        return slow;
    }
}
