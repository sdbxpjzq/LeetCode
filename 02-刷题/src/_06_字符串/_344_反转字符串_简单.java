package _06_字符串;


/**
 * 344. 反转字符串 简单
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * <p>
 * 示例 1：
 * 输入：['h','e','l','l','o']
 * 输出：['o','l','l','e','h']
 * <p>
 * 示例 2：
 * 输入：['H','a','n','n','a','h']
 * 输出：['h','a','n','n','a','H']
 */
public class _344_反转字符串_简单 {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        for (char c : s) {
            System.out.println(c);
        }
    }

    // 双指针 交换
    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        // for (int i = 0; i < s.length / 2; i++) {
        //     char tmp = s[start];
        //     s[start] = s[end];
        //     s[end] = tmp;
        //     start++;
        //     end--;
        // }
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }

    }
}
