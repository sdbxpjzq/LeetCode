package _06_字符串._3_无重复字符的最长子串_中等;

import java.util.HashSet;

public class Solution_1 {
    public int lengthOfLongestSubstring2(String s) {
        HashSet<Character> set = new HashSet<>();
        int start = 0, end = 0, maxLen = 0;
        while (end < s.length()) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;
                maxLen = Math.max(maxLen, set.size());
            } else {
                set.remove(s.charAt(start));
                start++;
            }
        }
        return maxLen;
    }
}
