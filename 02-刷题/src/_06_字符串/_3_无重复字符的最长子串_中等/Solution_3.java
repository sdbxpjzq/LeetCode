package _06_字符串._3_无重复字符的最长子串_中等;

import java.util.HashMap;
import java.util.HashSet;

public class Solution_3 {
    public static void main(String[] args) {
        String str = "abcabcbb";
        int i = lengthOfLongestSubstring(str);
        System.out.println(i);
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int left = 0, right = 0, maxLen = 0;
        // Map(字符, 下标)
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (; right < chars.length; right++) {
            if (map.containsKey(chars[right])) {
                // left 到 重复元素的下一个位置
                // zz 滑动窗口 left 指针不能往后退
                left = Math.max(map.get(chars[right]) + 1, left);
                // map.put(chars[right], right);
                // maxLen = Math.max(maxLen, right - left + 1);
            } else {
                // map.put(chars[right], right);
                // zz 固定公式: 求两个 下标之前的距离- (right - left + 1)
                // maxLen = Math.max(maxLen, right - left + 1);
            }
            // 公共部分提出来
            map.put(chars[right], right);
            // zz 固定公式: 求两个 下标之前的距离- (right - left + 1)
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
