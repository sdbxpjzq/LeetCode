package _06_字符串._76_最小覆盖子串_困难;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /*
    *
    * string s, t;
// 在 s 中寻找 t 的「最小覆盖子串」
int left = 0, right = 0;
string res = s;
// 先移动 right 寻找可行解
while(right < s.size()) {
    window.add(s[right]);
    right++;
    // 找到可行解后，开始移动 left 缩小窗口
    while (window 符合要求) {
        // 如果这个窗口的子串更短，则更新结果
        res = minLen(res, window);
        window.remove(s[left]);
        left++;
    }
}
return res;
    *
    *
    * */
    public String minWindow(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        String res = "";

        // 哈希表 needs 记录字符串 t 中包含的字符及出现次数，
        Map<Character, Integer> needs = new HashMap<>();
        // 哈希表 window 记录当前「窗口」中包含的字符及出现的次数。
        Map<Character, Integer> window = new HashMap<>();

        int sLen = sArr.length, tLen = tArr.length;
        for(int i = 0; i < tLen; i++) {
            char ch = tArr[i];
            needs.put(ch, needs.getOrDefault(ch, 0) + 1);
        }
        int left = 0, right = 0, min = Integer.MAX_VALUE;
        while(right < sLen) {
            char sChar = sArr[right];
            window.put(sChar, window.getOrDefault(sChar, 0) + 1);
            while(check(window, needs)) {
                if((right - left + 1) < min) {
                    min = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                char ch2 = s.charAt(left);
                window.put(ch2, window.get(ch2) - 1);
                if(window.get(ch2) == 0) {
                    window.remove(ch2);
                }
                left++;
            }
            right++;
        }
        return res;
    }

    //当前窗口是否符合题目条件
    public boolean check(Map<Character, Integer> window, Map<Character, Integer> chars) {
        for(char ch : chars.keySet()) {
            if(!window.containsKey(ch) || (window.get(ch) < chars.get(ch))) {
                return false;
            }
        }
        return true;
    }
}
