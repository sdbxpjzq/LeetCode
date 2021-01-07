package _06_字符串._125_验证回文串_简单;

public class Solution_1 {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            // 判断是不是 字母或数字
            while (!Character.isLetterOrDigit(s.charAt(left)) && left < right) {
                left++;
            }
            // 判断是不是 字母或数字
            while (!Character.isLetterOrDigit(s.charAt(right)) && left < right) {
                right--;
            }

            // 英文字符值判断
            if (Character.toLowerCase(s.charAt(left))  != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
