package _06_字符串._5_最长回文子串_中等;

public class Solution_2 {
    public static void main(String[] args) {
        String s = longestPalindrome("1221");
        System.out.println(s);
    }

    public static String longestPalindrome(String s) {

        int len = s.length();
        // 状态容器
        boolean[][] dp = new boolean[len][len];
        //初始化, 一个字母是true
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        int max = 0, start = 0;
        char[] chars = s.toCharArray();
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < len - 1 && i < j; i++) {
                // if (s.charAt(i) != s.charAt(j)) { // 性能较差
                if (chars[i] != chars[j]) { // 先转数组 性能高
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && (j - i + 1) > max) {
                    max = j - i + 1;
                    start = i;
                }

            }
        }

        return s.substring(start, start+max);

    }


}
