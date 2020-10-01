package _06_排序._02_常考的排序算法._05_快速排序;

public class 快速排序V2 {

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

    private static int Partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            if (left < right) {
                arr[left] = arr[right];
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            if (left < right) {
                arr[right] = arr[left];
            }
        }
        arr[left] = pivot;
        return left;
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
