package _06_字符串._76_最小覆盖子串_困难;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<Character, Integer>();
        HashMap<Character, Integer> window = new HashMap<Character, Integer>();
        // 将需要涵盖的字符插入到need字典中
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        // 滑动窗口的左右指针
        int left = 0, right = 0;
        // 最小字符起始的索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        int valid = 0;
        while (right < s.length()) {
            // 需要插入的字符串
            char in = s.charAt(right);
            right++;
            // 判断是否是子串中的字符
            if (need.containsKey(in)) {
                window.put(in, window.getOrDefault(in, 0) + 1);
                if (window.get(in).equals(need.get(in))) {
                    valid++;
                }
            }
            // 收缩字符
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // 需要移出的字符
                char out = s.charAt(left);
                left++;
                if (need.containsKey(out)) {
                    if (window.get(out).equals(need.get(out))) {
                        valid--;
                    }
                    window.put(out, window.getOrDefault(out, 0) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
