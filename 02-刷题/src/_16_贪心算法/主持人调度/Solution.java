package _16_贪心算法.主持人调度;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] a = {{1, 4}, {2, 3}};
        help(2, a);
    }

    public static void help(int k, int[][] time) {
        int[][] a = time;
        int[][] b = time;
        Arrays.sort(a, (v1, v2) -> v1[0] - v2[0]);
        Arrays.sort(b, (v1, v2) -> v1[1] - v2[1]);

        int end = 0, result = 0;
        for (int i = 0; i < k; i++) {
            if (a[i][0] >= b[end][1]) {
                end += 1;
            } else {
                result += 1;
            }
        }
        System.out.println(result);
    }

}
