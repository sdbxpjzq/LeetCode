package _06_字符串._680_验证回文字符串Ⅱ_简单;

public class Solution_1 {
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();

        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (chars[start] == chars[end]) {
                start++;
                end--;
            } else {
                return checkHuiWen(chars, start, end - 1) || checkHuiWen(chars, start + 1, end);
            }
        }
        return true;
    }

    private boolean checkHuiWen(char[] chars, int start, int end) {
        while (start < end) {
            if (chars[start] == chars[end]) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

}
