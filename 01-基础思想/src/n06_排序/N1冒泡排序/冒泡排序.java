package n06_排序.N1冒泡排序;

import java.util.Arrays;

public class 冒泡排序 {
    public static void main(String[] args) {
        int[] nums2 = {1, 22, 3, 4, 5};
        maoPao(nums2);

    }


    /**
     * 推荐这个
     * flag 用来做优化
     */
    private static void maoPao(int[] nums) {
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                count++;
                if (nums[j] > nums[j + 1]) {
                    //交换
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    // 有交换 设置成 true
                    flag = true;
                }
            }
            System.out.println("第" + (i + 1) + "趟排序数组");
            System.out.println(Arrays.toString(nums));

            //优化
            if (flag) {
                flag = false;
            } else {
                break;
            }
        }

        System.out.println("比较次数: " + count);
    }




}
