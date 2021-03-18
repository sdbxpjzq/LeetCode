package _06_字符串._392_判断子序列_简单;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        if (s.length() > t.length()) {
            return false;
        }
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int ti = 0, si = 0;
        while (ti < tt.length && si < ss.length) {
            if (ss[si] == tt[ti]) {
                ti++;
                si++;
            } else {
                ti++;
            }
        }
        if (si == ss.length) {
            return true;
        }
        return false;
    }
}
