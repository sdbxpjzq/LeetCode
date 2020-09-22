package _01_数组;

/**
 * 26. 删除排序数组中的重复项
 * 给定一个排序(有序)数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例1:
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class _26_删除排序数组中的重复项_简单 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,4,4,5};
        int i = new _26_删除排序数组中的重复项_简单().removeDuplicates(nums);
    }

    /**
     * 有点利用 retainAll(交集)  的思想
     *
     * @param nums
     * @return 新的长度
     */
    public int removeDuplicates(int[] nums) {
        int w = 0;
        // 从第一个开始判断
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[++w] = nums[i];
            }
        }

        return w + 1;
    }
}
