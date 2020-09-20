package 哈希表;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词 简单
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 什么是异位词?
 * 两个字符串中的 相同字符 的数量 要对应相等
 *
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _242_有效的字母异位词_简单 {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        String s2 = "rat", t2 = "car";

        boolean flag = isAnagramV3(s, t);
        System.out.println(flag);

        //排序
        // boolean flag = isAnagramV2(s, t);
        // System.out.println(flag);


        // boolean flag = isAnagram(s, t);
        // System.out.println(flag);
        // boolean flag2 = isAnagram(s2, t2);
        // System.out.println(flag2);


    }

    // 用数组计数 利用了下标
   public static boolean isAnagramV3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // 题目中说是小写字母,
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for (int i : arr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    // 排序
    public static boolean isAnagramV2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChr = s.toCharArray();
        char[] tChr = t.toCharArray();
        Arrays.sort(sChr);
        Arrays.sort(tChr);
        return Arrays.equals(sChr, tChr);
    }


    // 哈希表 自己写的挺笨的
    // public static boolean isAnagram(String s, String t) {
    //     char[] sChr = s.toCharArray();
    //     char[] tChr = t.toCharArray();
    //     HashMap<Character, Integer> map = new HashMap<>(32);
    //     for (char c : sChr) {
    //         map.merge(c, 1, Integer::sum);
    //     }
    //     for (char c : tChr) {
    //         Integer num = map.get(c);
    //         if (num == null) {
    //             return false;
    //         } else {
    //             map.put(c, num - 1);
    //         }
    //     }
    //
    //     for (Map.Entry<Character, Integer> entry : map.entrySet()) {
    //         Integer num = entry.getValue();
    //         if (num != 0) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}
