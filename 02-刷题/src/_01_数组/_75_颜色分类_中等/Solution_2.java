package _01_数组._75_颜色分类_中等;

public class Solution_2 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        sortColors(nums);
        for (int num : nums) {
            System.out.println(num);
            ;
        }
    }

    public static void sortColors(int[] nums) {
        //定义三个变量，p0表示数组最左边，0的区域，p2是数组最右边2的区域
        //cur就是当前遍历的指针
        int left = 0;
        int right = nums.length - 1;
        int cur = 0;
        while (cur <= right) {
            //如果当前指向的是0，就把这个元素交换到数组左边
            //也就是跟p0指针交换，之后cur，p0就往前一动一位
            if (nums[cur] == 0) {
                swap(nums, cur, left);
                ++cur;
                ++left;
                //如果当前指向的是2，就把这个元素交换到数组右边
                //也就是跟p2指针交换，注意此时cur指针就不用移动了
                //因为右边的一片区域都是2，只要把元素交换过去就可以了，cur不用移动
            } else if (nums[cur] == 2) {
                swap(nums, cur, right);
                --right;
                //如果是1的话，就不用交换
            } else {
                ++cur;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
