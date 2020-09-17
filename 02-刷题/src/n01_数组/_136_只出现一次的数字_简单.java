package n01_数组;

/**
 * 136 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度 - O(n)。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例1
 * 输入: [2,2,1]
 * 输出: 1
 * <p>
 * 示例2
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 暴力: Set
 */
public class _136_只出现一次的数字_简单 {

    public static void main(String[] args) {
        // todo 异或 规律
        System.out.println(2 ^ 2); // 0 , 相同的数异或为0: n ^ n => 0
        // System.out.println(0 ^ 24); // 24,任何数于0异或为任何数 0 ^ n => n
        // System.out.println(2 ^ 4 ^ 2); // a ^ b ^ c <=> a ^ c ^ b
        // System.out.println(2 ^ 2 ^ 4); // a ^ b ^ c <=> a ^ c ^ b

        int[] nums = {2,3,2,4,4};
        int i = new _136_只出现一次的数字_简单().singleNumber(nums);
        System.out.println(i);
    }

    /**
     * 异或
     * <p>
     * var a = [2,3,2,4,4]
     * 2 ^ 3 ^ 2 ^ 4 ^ 4等价于 2 ^ 2 ^ 4 ^ 4 ^ 3 => 0 ^ 0 ^3 => 3
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

}
