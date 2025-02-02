package _06_排序._02_常考的排序算法._05_快速排序;

import java.util.Arrays;

/**
 * 算法思想:
 * 也采用了分治的思想
 * 把原始的数组筛选成较小和较大的两个子数组, 然后递归的排序两个子数组
 * 在分成较小和较大的两个子数组过程中, 如何选定一个基准值很重要
 * <p>
 * <p>
 * - 只需要开辟`O(1)空间`, 直接对原数组修改
 * <p>
 * - 递归次数为`logn`,所以整理的空间复杂度完全取决于压栈的次数
 * <p>
 * <p>
 * 如何选择基准
 * 1. 选择第一个或者最后一个
 * 如果待排序数是随机的，那么选择第一个或者最后一个作基准是没有什么问题的，
 * 这也是我们最常见到的选择方案。但如果待排序数据已经排好序的，就会产生一个很糟糕的分割。
 * 几乎所有的数据都被分割到一个集合中，而另一个集合没有数据。
 * 这样的情况下，时间花费了，却没有做太多实事。而它的时间复杂度就是最差的情况O(N^2)。因此这种策略是绝对不推荐的。
 * <p>
 * 2. 随机选择
 * 随机选择基准是一种比较安全的做法。因为它不会总是产生劣质的分割。
 * randomPivot(int[] nums, int start, int end)
 * <p>
 * 3.选择三数中值
 * <p>
 * 从前面的描述我们知道，如果能够选择到数据的中值，那是最好的，因为它能够将集合近乎等分为二。
 * 但是很多时候很难算出中值，并且会耗费计算时间。因此我们随机选取三个元素，
 * 并用它们的中值作为整个数据中值的估计值。在这里，我们选择最左端，最右端和中间位置的三个元素的中值作为基准。
 * <p>
 * 1 9 10 3 8 7 6 2 4
 * 左端元素为1，位置为0，右端元素为4，位置为8，则中间位置为[0+8]/2=4，中间元素为8。那么三数中值就为4（1，4，8的中值）。
 */
public class 快速排序 {

    public static void main(String[] args) {
        int[] arr = {1, 6, 2, 4, 4, 3, 5, 6};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        // quickSort(arr, 0, arr.length - 1);
        quickSortV3(arr, 0, arr.length - 1);
        // quickSortV3(arr, 0, arr.length - 1);

        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSortV3(int[] arr, int left, int right) {
        // 是否只剩下一个元素
        if (left >= right) {
            // 递归退出
            return;
        }
        // 基准值
        int pivot = partition(arr, left, right);
        quickSortV3(arr, left, pivot - 1);// left ~ pivot-1 的元素都比小
        quickSortV3(arr, pivot + 1, right);
    }

    //划分方法
    private static int partition(int[] a, int left, int right) {
        int mid = left;

        while (left < right) {
            while (left < right && a[right] >= a[mid]) {
                right--;
            }

            while (left < right && a[left] <= a[mid]) {
                left++;
            }

            if (left < right) {
                swap(a, left, right);
            }
        }
        swap(a, mid, left);
        return left;
    }

    //交换方法
    private static void swap(int[] a, int left, int right) {
        int t = a[left];
        a[left] = a[right];
        a[right] = t;
    }


}