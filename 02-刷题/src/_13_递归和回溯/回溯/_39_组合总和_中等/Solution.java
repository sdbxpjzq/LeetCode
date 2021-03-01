package _13_递归和回溯.回溯._39_组合总和_中等;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和 中等
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 *
 * 示例 2：
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    private List result = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        help(candidates, new LinkedList<>(), target, 0);
        return result;
    }

    private void help(int[] arr, List<Integer> path, int target, int start) {
        if (target == 0) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (arr[i] > target) {
                continue;
            }
            path.add(arr[i]);
            // 注意target , 可以使用重复的
            help(arr, path, target, i);
            path.remove(path.size()-1);
        }
    }
}
