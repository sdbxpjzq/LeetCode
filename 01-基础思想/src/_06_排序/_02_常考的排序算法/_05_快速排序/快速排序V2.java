package _06_排序._02_常考的排序算法._05_快速排序;

import java.util.Stack;

public class 快速排序V2 {
    public static void main(String[] args) {
        int[] arr = {1, 6, 2, 4, 4, 3, 5, 6};
        nonRec_quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void nonRec_quickSort(int[] arr, int left, int right) {
        // 用栈模拟
        Stack<Integer> stack = new Stack<>();
        if (left < right) {
            stack.push(right);
            stack.push(left);
            while (!stack.isEmpty()) {
                int l = stack.pop();
                int r = stack.pop();
                int pivot = Partition(arr, l, r);
                if (l < pivot - 1) {
                    stack.push(pivot - 1);
                    stack.push(l);
                }
                if (r > pivot + 1) {
                    stack.push(r);
                    stack.push(pivot + 1);
                }
            }
        }
    }

    /**
     * 挖坑法的另一种形式
     */
    private static void quickSortV3(int[] arr, int left, int right) {
        // 是否只剩下一个元素
        if (left >= right) {
            // 递归退出
            return;
        }
        // 基准值
        int pivot = Partition(arr, left, right);
        quickSortV3(arr, left, pivot - 1);// left ~ pivot-1 的元素都比小
        quickSortV3(arr, pivot + 1, right);
    }

    private static int Partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            // if (left < right) {
            //     arr[left] = arr[right];
            // }
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            // if (left < right) {
            //     arr[right] = arr[left];
            // }
            if (left < right) {
                int tmp = arr[right];
                arr[right] = arr[left];
                arr[left] = tmp;
            }
        }
        // 双指针重合, 交换 pivot 和 left
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
