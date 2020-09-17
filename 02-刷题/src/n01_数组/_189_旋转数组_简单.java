package n01_数组;

/**
 * 189  旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3 , 旋转k次
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * 示例2:
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * <p>
 * 说明:
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 */
public class _189_旋转数组_简单 {
    public static void main(String[] args) {
        // int[] nums = {-1,-100,3,99}; //输出 3,99,-1,-100
        int[] nums = {1,2,3,4,5,6,7}; //输出 5,6,7,1,2,3,4
        new _189_旋转数组_简单().rotate(nums, 2);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    /**
     * todo 环状替换（巧妙） --不理解
     * <p>
     * 把数组当成环形的，把每个元素放到其后k个位置
     * 比如[1 , 2 , 3 , 4 , 5 , 6 , 7 , 8]， k=2
     * 可以把这8个元素依次放在一个八边形的各个顶点，从元素为 1 的顶点开始依次往前移动 2个位置，
     * 最后的数组[7 , 8 , 1 , 2 , 3 , 4 , 5 , 6]即为结果
     * <p>
     * ![](https://youpaiyun.zongqilive.cn/image/20200827193342.png)
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }


    /**
     * todo 反转法
     * <p>
     * 当我们旋转k次后，k%n个尾部元素会移动到数组前头，剩余的元素被往后移动
     * <p>
     * 首先将所有数组反转，接着再把前k个元素反转，最后再反转后n-k个元素
     * 假设nums=[1 , 2 , 3 , 4 , 5 , 6 , 7] n = 7且 k =3
     * 1. 反转所有元素：[7 , 6 , 5, 4 , 3 , 2 , 1]
     * 2. 反转前k个元素：[5 , 6 , 7 , 4 , 3, 2 , 1]
     * 3. 反转后n-k个元素：[5 , 6 , 7 , 1 , 2 , 3 , 4]此时即为结果
     * <p>
     * 时间复杂度: O(n), 反转了3次, 相当于3*O(n), 还是O(n)
     */
    public void rotateV2(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    // 反转
    private void reverse(int[] nums, int start, int end) {
        // 注意调条件
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    /**
     * todo 暴力方法
     */
    public void rotateV1(int[] nums, int k) {
        int length = nums.length;
        for (int i = 1; i <= k; i++) {
            int tmp = nums[length - 1];
            for (int j = 1; j < length; j++) {
                nums[length - j] = nums[length - j - 1];
            }
            nums[0] = tmp;
        }
    }


}
