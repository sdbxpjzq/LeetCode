package _06_排序._02_常考的排序算法._06_归并排序;

import java.util.Arrays;

/**
 * 采用了分治的思想，比较适用于处理较大规模的数据，但比较耗内存(需要开辟新空间)
 * <p>
 * 通过递归的方式将大的数组一直分割，直到数组的大小为 1，此时只有一个元素，那么该数组就是有序的了，
 * 之后再把两个数组大小为1的合并成一个大小为2的，再把两个大小为2的合并成4的 ….. 直到全部小的数组合并起来。
 */
public class MergeSort推荐 {

    public static void main(String[] args) {
        int arr[] = {8, 4, 5, 7, 1, 3, 6, 2}; //


        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));


        mergeSort(arr, 0, arr.length - 1);

        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    // 归并排序
    public static void mergeSort(int[] arr, int start, int end) {
        // 如果 left == right，表示数组只有一个元素，则不用递归排序
        if (start >= end) {
            return;
        }
        // 从中间将数组分成2个部分
        int mid = start + (end - start) / 2;
        // 对左半部分进行排序
        mergeSort(arr, start, mid);
        // 对右半部分进行排序
        mergeSort(arr, mid + 1, end);
        //进行合并
        merge(arr, start, mid, end);
    }

    // 合并函数，把两个有序的数组合并起来
    // arr[left..mid]表示一个数组，arr[mid+1 .. right]表示一个数组
    private static void merge(int[] arr, int start, int mid, int end) {
        int leftLen = mid - start + 1;
        int rightLen = end - (mid + 1) + 1;
        int[] L = new int[leftLen];
        int[] R = new int[rightLen];
        for (int i = 0; i < leftLen; i++) {
            L[i] = arr[start + i];
        }

        for (int j = 0; j < rightLen; j++) {
            R[j] = arr[mid + 1 + j];
        }


        // 两个指针
        int l = 0, r = 0, k = start;
        while (l < leftLen && r < rightLen) {
            if (L[l] <= R[r]) {
                arr[k] = L[l];
                l++;
            } else {
                arr[k] = R[r];
                r++;
            }
            k++;
        }

        while (l < leftLen) {
            //左边的有序序列还有剩余的元素，就全部填充到
            arr[k] = L[l];
            k++;
            l++;
        }

        while (r < rightLen) {
            //右边的有序序列还有剩余的元素，就全部填充到
            arr[k] = R[r];
            k++;
            r++;
        }
    }
}
