package _06_排序._02_常考的排序算法._06_归并排序;

import java.util.Arrays;

/**
 * 300分钟搞定算法视频 的写法
 *分治思想
 *算法思想:
 * 一直递归的把子数组划分成更小的子数组, 直到子数组里面只有一个元素;
 * 依次按照递归的返回顺序, 不断的合并排序好的子数组, 直到最后把整个数组
 *
 * 时间复杂度: O(nlogn)
 *
 * 空间复杂度: O(n)
 *
 */
public class 归并排序V3 {
    public static void main(String[] args) {
        int arr[] = {8, 4, 5, 7, 1, 3, 6, 2}; //


        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        sort(arr, 0, arr.length - 1);

        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int lo, int hi) {
        // 是不是只剩下最后一个元素
        if (lo >= hi) {
            return;
        }
        // 从中间将数组分成2个部分
        int mid = lo + (hi - lo) /2;
        // 递归的 分别将左右2部分排好序
        sort(arr, lo, mid);
        sort(arr, mid +1, hi);

        // 将排好序的 左右2部分 合并
        merge(arr, lo, mid , hi);
    }


    private static void merge(int[] arr, int lo, int mid, int hi) {
        // 复制一分数组, 因为需要修改原来的数组
        int[] copy = arr.clone();

        // k-从什么位置开始修改原来的数组
        // i-左半边的起始位置
        // j- 右半边的起始位置
        int k = lo,
                i = lo,
                j = mid +1;
        while (k<=hi) {
            if (i> mid) {
                // 左半边的数都处理完毕了, 只剩下右边的数, 只需要将右半边的数逐个拷贝
                arr[k++] = copy[j++];
            }else if (j > hi) {
                // 右半边的数都处理完毕了, 只剩下左边的数, 只需要将左半边的数逐个拷贝
                arr[k++] = copy[i++];
            }else if (copy[j] < copy[i]) {
                // 右边的数 < 左边的数
                arr[k++] = copy[j++];
            }else {
                // 右边的数 > 左边的数
                arr[k++] = copy[i++];
            }
        }
    }


}
