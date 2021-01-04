package _06_字符串._3_无重复字符的最长子串_中等;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.HashSet;

public class Solution_1 {
    public static void main(String[] args) {
        String str = "abcabcbb";
        int i = lengthOfLongestSubstring(str);
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            // 创建一个存放字符的集合
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                // 判断集合是否存在第 j 个字符
                if (set.contains(s.charAt(j))) {
                    break;
                }
                set.add(s.charAt(j));
            }
            maxLen = Math.max(maxLen, set.size());
        }

        return maxLen;
    }
}
