package _06_字符串._5_最长回文子串_中等;

public class Solution_1 {
    public static void main(String[] args) {
        String s = longestPalindrome("1221");
        System.out.println(s);
    }
    public static String longestPalindrome(String s) {
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int currMax = Math.max(m2(s, i, i), m2(s, i, i + 1));
            if (currMax > max) {
                max = currMax;
                start = i - (currMax + 1) / 2 + 1;
            }
        }
        return s.substring(start, start + max);// index:[start, start+max-1]
    }

    private static int m2(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }


}
