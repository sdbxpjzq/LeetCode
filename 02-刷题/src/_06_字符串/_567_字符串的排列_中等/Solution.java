package _06_字符串._567_字符串的排列_中等;

import java.util.Arrays;

public class Solution {
    // 滑动窗口

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) return false;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        //窗口内,次数统计
        for (int i = 0; i < len1; i++) {
            arr1[s1.charAt(i) - 'a']++; // 当前字母到 a 的距离
            arr2[s2.charAt(i) - 'a']++;
        }
        // 滑动窗口
        int left = 0, right = len1-1;
        while (right< len2) {
            if (Arrays.equals(arr1,arr2)) {
                return true;
            }
            // 更新窗口右边的
            right++;
            if (right != len2) {
                arr2[s2.charAt(right) - 'a']++;
            }
            // 更新窗口左边的
            arr2[s2.charAt(left) - 'a']--;
            left++;
        }
        return false;
    }
}
