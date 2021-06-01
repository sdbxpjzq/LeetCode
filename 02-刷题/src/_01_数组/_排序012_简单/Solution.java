package _01_数组._排序012_简单;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {2, 0, 1, 0, 1, 0, 2};
        int[] sort = sort(arr);
        for (int i : sort) {
            System.out.println(i);
        }
    }

    public static int[] sort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int cur = 0;
        while (cur < right) {
            if (arr[cur] == 0) {
                swap(arr, cur, left);
                left++;
                cur++;
            } else if (arr[cur] == 1) {
                cur++;
            } else if (arr[cur] == 2) {
                swap(arr, cur, right);
                right--;
            }
        }
        return arr;
    }

    private static void swap(int[] a, int cur, int left) {
        int t = a[left];
        a[left] = a[cur];
        a[cur] = t;
    }
}
