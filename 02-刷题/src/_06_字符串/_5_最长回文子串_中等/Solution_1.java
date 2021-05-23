package _06_字符串._5_最长回文子串_中等;

public class Solution_1 {
    public static void main(String[] args) {
        String s = longestPalindrome("cbbd");
        System.out.println(s);
    }

    private static int[] range = new int[2];
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len == 0 || len == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            help(chars, len, i, i);
            help(chars, len, i , i+1);
        }
        return s.substring(range[0], range[1]); // 范围是左闭右开 [range[0],range[1])
    }

    private static void help(char[] chars, int len, int start, int end) {
        while (start >= 0 && end <= len - 1) {
            if (chars[start] == chars[end]) {
                start--;
                end++;
            } else {
                break;
            }
        }
        // 注意 start + 1
        if ((end - (start + 1)) > (range[1] - range[0])) {
            range[0] = start + 1;
            range[1] = end;
        }
    }


    // public static String longestPalindrome(String s) {
    //     int max = 0;
    //     int start = 0;
    //     for (int i = 0; i < s.length(); i++) {
    //         int currMax = Math.max(m2(s, i, i), m2(s, i, i + 1));
    //         if (currMax > max) {
    //             max = currMax;
    //             start = i - (currMax + 1) / 2 + 1;
    //         }
    //     }
    //     return s.substring(start, start + max);// index:[start, start+max-1]
    // }
    //
    // private static int m2(String s, int left, int right) {
    //     while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
    //         left--;
    //         right++;
    //     }
    //     return right - left - 1;
    // }


}
