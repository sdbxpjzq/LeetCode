package _01_数组._88_合并两个有序数组_简单;

public class Solution_1 {
    // nums1 和 nums2 的元素数量分别为 m 和 n
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 新数组 最大下标
        int k = m + n - 1;
        int i1 = m - 1; // mum1 最大下标
        int i2 = n - 1; // mum2 最大下标
        while (i1 >= 0 && i2 >= 0) {
            if (nums1[i1] > nums2[i2]) {
                nums1[k] = nums1[i1];
                i1--;
            } else {
                nums1[k] = nums2[i2];
                i2--;
            }
            k--;
        }
        // 处理剩下的 num2 数组
        while (i2 >= 0) {
            nums1[k] = nums2[i2];
            k--;
            i2--;
        }

    }
}
