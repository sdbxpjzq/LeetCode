package _06_字符串._647_回文子串的个数_中等;

public class Solution {
    int num = 0;

    public int countSubstrings(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            help(chars, len, i, i); //回文串长度为奇数
            help(chars, len, i, i + 1); //回文串长度为偶数
        }
        return num;
    }

    public void help(char[] chars, int len, int start, int end) {
        while (start >= 0 && end < len) {
            if (chars[start] == chars[end]) {
                start--;
                end++;
                num++;
            } else {
                break;
            }
        }
    }
}
