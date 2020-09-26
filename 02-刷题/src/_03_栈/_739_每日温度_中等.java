package _03_栈;

import java.util.Stack;

/**
 * 739. 每日温度
 * <p>
 * 请根据每日 气温 列表，重新生成一个列表。
 * 对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
 * 你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 说明：
 * 73的时候只需要等1天，温度是74比73大。
 * 74的时候只需要等1天，温度是75比74大。
 * 75的时候只需要等4天，温度是76比75大。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _739_每日温度_中等 {

    /**
     *利用栈
     * 题解
     * https://mp.weixin.qq.com/s/Qn2X0d7P3tFMVMvl-g7yuA
     *
     * 复杂度分析:
     * 该方法只需要对数组进行一次遍历，每个元素最多被压入和弹出堆栈一次，算法复杂度是 O(n)。
     */
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] >T[stack.peek()]) {
                Integer tmp = stack.pop();
                arr[tmp] = i-tmp;
            }
            stack.push(i);
        }
        return arr;
    }
}
