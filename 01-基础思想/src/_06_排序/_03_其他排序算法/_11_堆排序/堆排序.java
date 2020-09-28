package _06_排序._03_其他排序算法._11_堆排序;

import java.util.Arrays;

/**
 * 堆排序
 * 平均时间复杂度- O(nLogn), 不稳定排序
 * ![不稳定排序](https://youpaiyun.zongqilive.cn/image/20200909100518.png)
 *
 *
 * 性质:
 * 1. 是一个 完全二叉树
 * 2. 大顶堆 - 每个节点的值大于或等于其左右孩子节点的值 , 堆顶元素最大
 * 3. 小顶堆 - 每个节点的值小于或等于其左右孩子节点的值, 堆顶元素最小
 * <p>
 * 升序使用 - 大顶堆
 * 降序使用 - 小顶堆
 * <p>
 * 排序思想- 大顶堆为例:
 * 1. 构建大顶堆 ( 时间复杂度 O(n) ), 那么这时，整个序列的最大值就是堆顶的根节点
 * 2、将堆顶元素与最后一个元素交换，那么末尾元素就存入了最大值；
 * 3、将剩余的 n - 1个元素重新构建成一个大顶堆，重复上面的操作；反复执行，就能得到一个有序序列了。
 * <p>
 * 参考:
 * https://mp.weixin.qq.com/s/CE1ZHQkY2-zhLkoVxU1KmQ
 */
public class 堆排序 {

    public static void main(String[] args) {
        //要求将数组进行升序排序
        int arr[] = {4, 6, 8, 5, 9};
        // 创建要给80000个的随机的数组
        heapSort(arr);
        System.out.println("排序后=" + Arrays.toString(arr));
    }

    //编写一个堆排序的方法
    public static void heapSort(int arr[]) {
        int temp = 0;
        System.out.println("堆排序!!");

//		//分步完成
//		adjustHeap(arr, 1, arr.length);
//		System.out.println("第一次" + Arrays.toString(arr)); // 4, 9, 8, 5, 6
//
//		adjustHeap(arr, 0, arr.length);
//		System.out.println("第2次" + Arrays.toString(arr)); // 9,6,8,5,4


        //将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        //进行第一次调整
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

		/*
		 * 2).将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
　　			3).重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
		 */
        for (int j = arr.length - 1; j > 0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;

            //调整长度为j的那些
            //这里为什么填0呢
            //因为我们第一次调整的时候从左到右，从下到上调整的；
            //交换时只是变动了堆顶元素和末尾元素
            //末尾元素我们不用去管，因为已经是之前长度最大的了
            //只需要把当前堆顶元素找到合适的位置即可

            adjustHeap(arr, 0, j);
        }

        //System.out.println("数组=" + Arrays.toString(arr));

    }

    //将一个数组(二叉树), 调整成一个大顶堆

    /**
     * 功能： 完成 将 以 i 对应的非叶子结点的树调整成大顶堆
     * 举例  int arr[] = {4, 6, 8, 5, 9}; => i = 1 => adjustHeap => 得到 {4, 9, 8, 5, 6}
     * 如果我们再次调用  adjustHeap 传入的是 i = 0 => 得到 {4, 9, 8, 5, 6} => {9,6,8,5, 4}
     *
     * @param arr    待调整的数组
     * @param i      表示非叶子结点在数组中索引
     * @param length 表示对多少个元素继续调整， length 是在逐渐的减少
     */
    public static void adjustHeap(int arr[], int i, int length) {
        //非叶子节点的值
        int notLeafNodeVal = arr[i];
        //k的初始值为当前非叶子节点的左孩子节点的索引
        //k = 2 * k + 1表示再往左子节点找
        for (int k = i * 2 + 1; k < length; k = 2 * k + 1) {
            //如果k + 1还在待调整的长度内，且右子树的值大于等于左子树的值
            //将k++，此时为当前节点的右孩子节点的索引
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            //如果孩子节点大于当前非叶子节点
            if (arr[k] > notLeafNodeVal) {
                arr[i] = arr[k];//将当前节点赋值为孩子节点的值
                i = k;//将i赋值为孩子节点的值，再看其孩子节点是否有比它大的
            } else {
                break;//能够break的保证是，我们是从左至右，从下到上进行调整的
                //只要上面的不大于，下面的必不大于
            }
        }
        //循环结束后，将i索引处的节点赋值为之前存的那个非叶子节点的值
        arr[i] = notLeafNodeVal;
    }

}

