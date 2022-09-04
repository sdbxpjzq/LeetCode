package _06_字符串._242_有效的字母异位词_简单;

import java.util.Arrays;

public class Solution {
    // 什么是异位词(同构), 满足3个条件
    //1.字符串长度相同, 2,字母都相同, 3,每个字母出现的频次一样

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // 26个英文字母
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr1[s.charAt(i) - 'a']++; // 当前字母到 a 的距离
            arr2[t.charAt(i) - 'a']++;
        }

        return Arrays.equals(arr1,arr2);
    }
}
