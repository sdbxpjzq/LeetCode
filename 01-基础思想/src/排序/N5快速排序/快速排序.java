package 排序.N5快速排序;

import java.lang.annotation.ElementType;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
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
        quickSortV2(arr, 0, arr.length - 1);
        // quickSortV3(arr, 0, arr.length - 1);

        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 选择三数中值
     */
    private static int medianPivot(int[] A, int left, int right) {
        int center = (left + right) / 2;
        if (A[left] > A[center]) {
            swap(A, left, center);
        }
        if (A[left] > A[right]) {
            swap(A, left, right);
        }
        if (A[center] > A[right]) {
            swap(A, center, right);
        }
        /*交换中值和倒数第二个元素*/
        swap(A, center, right - 1);
        return A[right - 1];

    }

    /**
     * 随机取 pivot
     */
    private static int randomPivot(int[] nums, int start, int end) {
        int randIndex = (int) (Math.random() % (end - start) + start);
        return nums[randIndex];
    }

    /**
     * todo 挖坑填数 关注这个吧, 性能好一些
     * 可以取第一个元素 做为 pivot,
     * 1. 先从右边开始找, 再从左边找, 顺序挺重要的
     */
    private static void quickSortV2(int[] arr, int start, int end) {
        if (start >= end) {
            // 递归退出
            return;
        }

        int left = start; //左下标
        int right = end; //右下标
        //pivot 取第一个值, 挖坑填数
        int pivot = arr[left];

        //比pivot 值大放到右边
        while (left < right) {
            //必须先找右边 在pivot的右边一直找,找到小于等于pivot值,才退出
            while (left < right && arr[right] >= pivot) {
                right--;
            }

            if (left < right) {
                arr[left] = arr[right];
            }

            //再找左边  在pivot的左边一直找,找到大于等于pivot值,才退出
            while (left < right && arr[left] <= pivot) {
                left++;
            }

            if (left < right) {
                arr[right] = arr[left];
            }


            if (left >= right) {
                arr[left] = pivot;
            }
        }
        quickSortV2(arr, start, right - 1);
        quickSortV2(arr, right + 1, end);

    }


    /**
     * 交换法
     */
    private static void quickSort(int[] arr, int L, int R) {
        if (L >= R) {
            // 递归退出
            return;
        }

        int left = L; //左下标
        int right = R; //右下标
        //pivot 中轴值
        int pivot = arr[(left + right) / 2];
        System.out.println(Arrays.toString(arr));
        System.out.println("基准值:" + pivot);
        //while循环的目的是让比pivot 值小放到左边
        //比pivot 值大放到右边
        while (left < right) {
            //在pivot的左边一直找,找到大于等于pivot值,才退出
            while (left < right && arr[left] < pivot) {
                left++;
            }
            //在pivot的右边一直找,找到小于等于pivot值,才退出
            while (left < right && arr[right] > pivot) {
                right--;
            }
            if (left < right) {
                //交换arr[left]和arr[right]的位置
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
            //继续遍历
            left++;
            right--;

        }
        quickSort(arr, L, right);
        quickSort(arr, left, R);
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * 挖坑法的另一种形式
     */
    private static void quickSortV3(int[] arr, int left, int right) {
        if (left >= right) {
            // 递归退出
            return;
        }
        int pivot;
        if (left < right) {
            pivot = Partition(arr, left, right);
            quickSortV3(arr, left, pivot - 1);// left ~ pivot-1 的元素都比小
            quickSortV3(arr, pivot + 1, right);
        }
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

}