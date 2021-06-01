package _01_数组._最小的k个数_中等;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        PriorityQueue<Integer> ints = smallestKV2(arr, 2);
        System.out.println(ints);
    }

    // 要遍历全部数组
    public static PriorityQueue<Integer> smallestKV2(int[] arr, int k) {
        // 最大堆, 堆顶是最大值
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });
        for (int num : arr) {
            if (queue.size() < k){
                queue.add(num);
            } else {
              if (queue.peek() > num) {
                  queue.poll();
                  queue.add(num);
              }
            }
        }
        return queue;
    }

    public static int[] smallestK(int[] arr, int k) {
        if (k >= arr.length) {
            return arr;
        }

        int left = 0;
        int high = arr.length - 1;
        int targrt = k - 1;
        while (left < high) {
            int pos = partition(arr, left, high);
            if (pos == targrt) {
                break;
            } else if (pos < targrt) {
                left = pos + 1;
            } else {
                high = pos - 1;
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;
            }

            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }
}
