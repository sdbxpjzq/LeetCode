package n07_查找算法.N2_插值查找;

/**
 * 插值查找算法，也要求数组是有序的
 * <p>
 * ![插值查找原理](https://youpaiyun.zongqilive.cn/image/20200901085806.png)
 * <p>
 * 他和二分法查找代码很相似，只不过计算 middle 的方式不一样。
 * <p>
 * 注意事项:
 * 对于数据量较大，关键字分布比较均匀的查找表来说，采用插值查找, 速度较快.
 * 关键字分布不均匀的情况下，该方法不一定比折半查找要好
 *
 */
public class 插值查找 {

    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1000, 1234};

        // int index = insertValueSearch(arr, 0, arr.length - 1, 1234);
        int index = insertValueSearchV2(arr, 0, arr.length - 1, 1234);
        System.out.println("index = " + index);
    }


    /**
     * 非递归写法
     * 功能：该函数用来实现插值查找算法
     * 输入：查找数组values,数组长度n,查找元素element
     * 输出：返回元素的位置
     */
    public static int insertValueSearchV2(int arr[], int left, int right, int findVal) {
        System.out.println("插值查找次数~~");

        //初始化起止端口号
        int from = 0;
        int to = arr.length - 1;
        //循环扫描
        while (from <= to) {
            //todo 采用插值算法得到中间元素的位置
            int mid = from + (to - from) * (findVal - arr[from]) / (arr[to] - arr[from]);
            //进行判断是否找到该元素
            if (arr[mid] > findVal) {
                to = mid - 1;
            } else if (arr[mid] < findVal) {
                from = mid + 1;
            } else {
                //找到该元素，返回
                return mid;
            }
        }
        //未能查找到该元素
        return -1;
    }


    //编写插值查找算法
    //说明：插值查找算法，也要求数组是有序的

    /**
     * @param arr     数组
     * @param left    左边索引
     * @param right   右边索引
     * @param findVal 查找值
     * @return 如果找到，就返回对应的下标，如果没有找到，返回-1
     */
    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {

        System.out.println("插值查找次数~~");

        //注意：findVal < arr[0]  和  findVal > arr[arr.length - 1] 必须需要
        //否则我们得到的 mid 可能越界
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }

        // todo 求出mid, 自适应, 这里和 二分
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal) { // 说明应该向右边递归
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 说明向左递归查找
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }

    }
}
