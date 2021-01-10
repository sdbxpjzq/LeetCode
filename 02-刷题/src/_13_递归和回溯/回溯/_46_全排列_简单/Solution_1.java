package _13_递归和回溯.回溯._46_全排列_简单;

import java.util.ArrayList;
import java.util.List;

public class Solution_1 {
    private List res = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        // 路径, 选择列表
        m(new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    /**
     *
     * @param track 路径
     * @param nums 选择列表 nums 中不存在于 track 的那些元素
     *             结束条件：nums 中的元素全都在 track 中出现
     */
    private void m(List<Integer> track, int[] nums, boolean[] visited) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == true) {
                continue;
            }
            // 做选择
            visited[i] = true;
            track.add(nums[i]);
            // 递归 进入下一层决策树
            m(track, nums, visited);
            // 取消选择
            track.remove(track.size()-1);
            visited[i] = false;

        }
    }


}
