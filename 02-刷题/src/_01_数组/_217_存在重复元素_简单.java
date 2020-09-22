package _01_数组;

import java.util.HashSet;

/**
 * 217. 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * 示例:
 * 输入: [1,2,3,1]
 * 输出: true
 */
public class _217_存在重复元素_简单 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        boolean b = new _217_存在重复元素_简单().containsDuplicate(nums);
        System.out.println(b);
    }


    /**
     *
     * 哈希碰撞
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>(1024);
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
