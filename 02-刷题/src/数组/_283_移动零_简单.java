package 数组;

/**
 * 283. 移动零
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class _283_移动零_简单 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 12};
        moveZeroes(nums);

        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        int w = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[w++] = nums[i];
            }
        }
        if (w < len) {
            for (int i = w; i < len; i++) {
                nums[i] = 0;
            }
        }

    }
}
