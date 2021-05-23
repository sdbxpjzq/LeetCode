package _15_数学._9_判断回文数;

public class Solution_1 {
    public static void main(String[] args) {
        boolean palindrome = isPalindrome(-121);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        return checkHuiWen(chars, 0, chars.length - 1);
    }

    // 检查是否是回文
    private static boolean checkHuiWen(char[] chars, int start, int end) {
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
