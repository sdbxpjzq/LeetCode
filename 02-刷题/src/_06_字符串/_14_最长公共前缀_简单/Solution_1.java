package _06_字符串._14_最长公共前缀_简单;


public class Solution_1 {
    public static void main(String[] args) {
        int c = "abcd".indexOf("c");
        System.out.println(c);
    }
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            // 前缀 出现开头的位置, 期望是 0
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0,prefix.length()-1);
            }
        }

        return prefix;
    }
}
