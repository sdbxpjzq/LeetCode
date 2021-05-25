package _06_字符串._3_无重复字符的最长子串_中等;

import java.util.HashSet;

public class Solution_1 {
    public  int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int start = 0, end = 0, maxLen = 0;
        while (end < s.length()) {
            if (!set.contains(chars[end])) {
                set.add(chars[end]);
                end++;
                maxLen = Math.max(maxLen, set.size());
            } else {
                set.remove(chars[start]);
                start++;
            }
        }
        return maxLen;
    }
}
