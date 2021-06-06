package _01_数组.最长无重复子数组_中等;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    // public int maxLength (int[] arr) {
    //     HashMap<Integer,Integer> map = new HashMap<>();
    //     int max = 1;
    //
    //     for(int start = 0, end = 0; end<arr.length ; end++){
    //         if(map.containsKey(arr[end])){
    //             //重复了
    //             start = Math.max(start, map.get(arr[end])+1);
    //             //注意：这里一定要取最大的start，不然就错误了
    //             //为什么？ 因为重复数字的索引很可能比start小
    //         }
    //         max = Math.max(max , end-start+1);
    //         map.put(arr[end],end);
    //     }
    //     return max;
    // }

    public int maxLength(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int start = 0, end = 0, maxLen = 0;
        while (end < arr.length) {
            if (!set.contains(arr[end])) {
                set.add(arr[end]);
                end++;
                maxLen = Math.max(maxLen, set.size());
            } else {
                set.remove(arr[start]);
                start++;
            }
        }
        return maxLen;
    }
    /*class Solution:
    def maxLength(self , arr ):
        # write code here


        for i in range(len(arr)):
            cur_value = arr[i]
            if cur_value not in res:
                res += [cur_value]
            else:
                res = res[res.index(cur_value)+1:] + [cur_value]
            if len(res) > length:
                length = len(res)
        return length
    * */
}
