package _06_字符串._3_无重复字符的最长子串_中等;

import java.util.HashMap;
import java.util.HashSet;

public class Solution_1 {
    /* 滑动窗口算法框架 *//*
    void slidingWindow(string s, string t) {


        int left = 0, right = 0;
        int valid = 0;
        while (right < s.size()) {
            // in 是将移入窗口的字符
            char in = s.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
        ...

            *//*** debug 输出的位置 ***//*
            printf("window: \n", left, right);
            */

    /********************//*

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // out 是将移出窗口的字符
                char out = s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
            ...
            }
        }
    }*/
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        // 将需要涵盖的字符插入到need字典中
        HashMap<Character, Integer> need = new HashMap<Character, Integer>();
        // 窗口
        HashMap<Character, Integer> window = new HashMap<Character, Integer>();
        for (char c : chars) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

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
