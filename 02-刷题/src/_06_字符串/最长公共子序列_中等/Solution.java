package _06_字符串.最长公共子序列_中等;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        String text1 = "1AB2345CD";
        String text2 = "12345EF";
        int i = maxLong(text1, text2);
        System.out.println(i);

    }
    public static int maxLong(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        char[] str1Arr = text1.toCharArray();
        char[] str2Arr = text2.toCharArray();
        int maxLen = 0;
        ArrayList<Character> list = new ArrayList<>();
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= str1Arr.length; i++) {
            for (int j = 1; j <= str2Arr.length; j++) {
                if (str1Arr[i-1] == str2Arr[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                if (dp[i][j] > maxLen) {
                    maxLen = dp[i][j];
                    list.add(str1Arr[i-1]);
                }
            }
        }
        System.out.println(list);
        return list.size();
        // return dp[str1.length()][str2.length()];
    }
}
