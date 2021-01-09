package _16_贪心算法._55_跳跃游戏_中等;

public class Solution_1 {
    public boolean canJump(int[] nums) {
        int max_i = 0;
        for (int i = 0; i < nums.length; i++) {
            //如果跳不到位置i，直接返回false
            if (i > max_i) {
                return false;
            }
            max_i = Math.max(max_i, i + nums[i]);
        }
        System.out.println(max_i);
        return max_i >= nums.length - 1;
    }
}
