package _06_字符串.最长公共子串_中等;


import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        String text1 = "1AB2345CD";
        String text2 = "12345EF";
        String i = LCS(text1, text2);
        System.out.println(i);
    }
    /**
     * 动态规划：我们用一个二维数组dp[i][j]表示第一个字符串前i个字符和第二个字符串前j个字符组成的最长公共字符串的长度。
     * 那么我们在计算dp[i][j]的时候，我们首先要判断s1.charAt(i)是否等于s2.charAt(j)，
     * 如果不相等，说明当前字符无法构成公共子串，所以dp[i][j]=0。
     * 如果相等，说明可以构成公共子串，我们还要加上他们前一个字符构成的最长公共子串长度，也就是dp[i-1][j-1]+1。
     */
    public static String LCS(String str1, String str2) {
        int maxLen = 0; // 最大长度
        int indexMax =0;
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();
        for (int i = 1; i <= str1Arr.length; i++) {
            for (int j = 1; j <= str2Arr.length; j++) {
                if (str1Arr[i-1] == str2Arr[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                if (dp[i][j] > maxLen) {
                    maxLen = dp[i][j];
                    indexMax=i-1;
                }
            }
        }
        if (maxLen == 0) {
            return "-1";
        }
        return str1.substring(indexMax - maxLen + 1, indexMax + 1);
    }


    public String LCSV2(String str1, String str2) {
        String result = "";
        int start = 0;
        int end = 1;
        while (end <= str2.length()) {
            String subStr = str2.substring(start, end);
            if (str1.contains(subStr)) {
                result = subStr;
            } else {
                start++;
            }
            end++;
        }
        return result;
    }
}
