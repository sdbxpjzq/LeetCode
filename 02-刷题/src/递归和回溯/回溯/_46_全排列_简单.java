package 递归和回溯.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 所谓全排列，就是把一堆字符按照一定的顺序排列起来，所有可能的组合。
 * 举个简单的例子，"123"的全排列为"123"、"132"、"213"、"231"、"312"、"321"。
 * <p>
 * 46. 全排列 简单
 * <p>
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class _46_全排列_简单 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> permute = permute(arr);
        System.out.println("最后结果:");
        System.out.println(permute);
    }

    /**
     *
     * 在枚举第一位的时候，就有三种情况
     * 在枚举第二位的时候，就只有两种情况（前面已经出现的一个数字不可以再出现）
     * 在枚举第三位的时候，就只有一种情况（前面已经出现的两个数字不可以再出现）
     *
     * 整个代码其实就干了这么一件事！而 第12行 的代码，
     *
     * 那这里还有一个很重要的代码，其实是 第19行，这一步其实是干啥！说白了就是在回到上一位时，我们要就把上一次的选择结果撤销掉。不然如果你之前选过了，后面不就不能继续用了么。
     */

    static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        dfs(nums, new ArrayList<>());
        return ans;
    }

    private static void dfs(int[] nums, List<Integer> tmp) {
        System.out.println(Arrays.toString(nums) + "," + tmp);
        if (tmp.size() == nums.length) { // 其实就是说当枚举到最后一位的时候，这个就是我们要的排列结果，所以我们要放入到全排列结果集中。
            ans.add(new ArrayList<>(tmp));
        } else {
            for (int num : nums) {
                if (!tmp.contains(num)) { // 把已经选择过的数字排除掉
                    tmp.add(num);
                    dfs(nums, tmp);
                    tmp.remove(tmp.size() - 1); // 就是在回到上一位时，我们要就把上一次的选择结果撤销掉。不然如果你之前选过了，后面不就不能继续用了么。
                }
            }
        }
    }

}
