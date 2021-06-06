package _06_字符串._30_串联所有单词的子串_困难;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private final Map<String, Integer> map = new HashMap<>();

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordsCount = words.length; // 有多少个单词
        int wordsLen = words[0].length(); // 单词的长度

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < wordsCount; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        char[] sArr = s.toCharArray();
        for (int i = 0; i < sArr.length - (wordsLen * wordsCount); i++) {

        }

        //
        // int wordLen = 0;
        // int[] needs = new int[26];
        // for (String word : words) {
        //     map.put(word, map.getOrDefault(word, 0) + 1);
        //     for (char ch : word.toCharArray()) {
        //         needs[ch - 'a']++;
        //         wordLen++;
        //     }
        // }
        // int targetLen = 0;
        // for (int i = 0; i < 26; i++) if (needs[i] > 0) targetLen++;
        //
        // int haveLen = 0, left = 0;
        // int[] window = new int[26];
        // char[] chars = s.toCharArray();
        // for (int right = 0; right < chars.length; right++) {
        //     int num = chars[right] - 'a';
        //     window[num]++;
        //     if (window[num] == needs[num]) haveLen++;
        //
        //     // 窗口长度需要跟单词串长度一致
        //     while (right - left + 1 == wordLen) {
        //         if (haveLen == targetLen) {
        //             if (match(s.substring(left, left + wordLen), words[0].length())) result.add(left);
        //         }
        //
        //         int leftNum = s.charAt(left) - 'a';
        //         if (window[leftNum] == needs[leftNum]) haveLen--;
        //         window[leftNum]--;
        //         left++;
        //     }
        // }
        //
        // return result;
    }

    public boolean match(String s, int length) {
        Map<String, Integer> temp = new HashMap<>(map);
        for (int i = 0; i < s.length(); i += length) {
            String word = s.substring(i, i + length);
            if (!temp.containsKey(word)) return false;
            temp.put(word, temp.getOrDefault(word, 0) - 1);
        }
        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            if (entry.getValue() != 0) return false;
        }
        return true;
    }
}
