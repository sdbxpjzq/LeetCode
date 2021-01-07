package _06_字符串._3_无重复字符的最长子串_中等;

import java.util.HashSet;

public class Solution_2 {

    public static void main(String[] args) {
        String str = "abcabcbb";
        int i = lengthOfLongestSubstring(str);
        System.out.println(i);
    }

    /*
    * HashSet<Character> set = new HashSet<>();
        int i = 0, j = 0, maxLen = 0;
        while (i < s.length() && j < s.length()){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                maxLen = Math.max(maxLen,j - i);
            }else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return maxLen;
    *
    * */

    public static int lengthOfLongestSubstring(String s) {
        // if (s == null || s.isEmpty()) {
        //     return 0;
        // }
        // int left = 0, right = 0, maxLen = 0;
        // char[] chars = s.toCharArray();
        // HashSet<Character> set = new HashSet<>();
        // for (; right < chars.length; right++) {
        //     if (set.add(chars[right])) {
        //         // 没完成
        //         return 0;
        //     }
        // }
return 0;
    }
}
