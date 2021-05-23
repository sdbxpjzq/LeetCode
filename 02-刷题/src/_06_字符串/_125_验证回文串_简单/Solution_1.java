package _06_字符串._125_验证回文串_简单;

public class Solution_1 {
    public static void main(String[] args) {
        boolean palindrome = isPalindrome("raceacar");
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        //只保存字母数字
        StringBuilder tmp = new StringBuilder(1024);
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetterOrDigit(chars[i])) {
                tmp.append(Character.toLowerCase(chars[i]));
            }
        }
        char[] chars1 = tmp.toString().toCharArray();
        return checkHuiWen(chars1, 0, chars1.length - 1);
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

    // public boolean isPalindrome(String s) {
    //     int left = 0;
    //     int right = s.length() - 1;
    //     while (left < right) {
    //         // 判断是不是 字母或数字
    //         while (!Character.isLetterOrDigit(s.charAt(left)) && left < right) {
    //             left++;
    //         }
    //         // 判断是不是 字母或数字
    //         while (!Character.isLetterOrDigit(s.charAt(right)) && left < right) {
    //             right--;
    //         }
    //
    //         // 英文字符值判断
    //         if (Character.toLowerCase(s.charAt(left))  != Character.toLowerCase(s.charAt(right))) {
    //             return false;
    //         }
    //         left++;
    //         right--;
    //     }
    //     return true;
    // }
}
