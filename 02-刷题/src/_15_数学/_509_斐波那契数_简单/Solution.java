package _15_数学._509_斐波那契数_简单;

import java.util.HashMap;

public class Solution {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        HashMap<Integer, Integer> map = new HashMap<>(1024);
        Integer i = map.get(n);
        if (i != null) {
            return i;
        }
        int res = fib(n - 1) + fib(n - 2);
        map.put(n, res);
        return res;
    }

    public int search(int[] array, int target) {
        // write code here
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                //判断mid之前是否有相同元素（即是否是第一个target）
                //mid!=0，注意是!=，这是输出结果的边界条件
                while (mid != 0 && (array[mid - 1] == array[mid])) {
                    --mid;
                }
                return mid;
            } else if (array[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
