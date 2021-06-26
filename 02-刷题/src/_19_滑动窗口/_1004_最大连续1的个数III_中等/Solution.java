package _19_滑动窗口._1004_最大连续1的个数III_中等;

public class Solution {

    /**
     * 思路：
     * 维护一个数字zeroCount，记录窗口内0的个数。
     * 维护两个指针，左指针、右指针，右指针每次走一步，如果当前指针数字是0，zeroCount加1；
     * 如果zeroCount大于 K，就是补0次数用完，左指针也要走一步；同时，如果左指针走之前的数是0的话，zeroCount还要减回1。
     * 最后的right - leht（也就是窗口的长度）就是最大的个数。因为这个窗口只会记录最大的1长度，不会缩小。
     */
    public int longestOnes(int[] nums, int k) {
        int start = 0, end = 0;
        int zeroCount = 0; // 窗口中0的个数
        int maxWindow = 0;//窗口的最大值
        int len = nums.length;
        while (end < len) {
            if (nums[end] == 0) {
                zeroCount++;
            }
            end++;
            //如果窗口中0的个数超过了K，要缩小窗口的大小，直到0的个数不大于K
            while (zeroCount > k) {
                if (nums[start] == 0) {
                    zeroCount--;
                }
                start++;
            }
            //记录最大的窗口
            maxWindow = Math.max(maxWindow, end - start + 1);
        }
        // 窗口值则是最长1的个数
        return maxWindow;
    }
}
