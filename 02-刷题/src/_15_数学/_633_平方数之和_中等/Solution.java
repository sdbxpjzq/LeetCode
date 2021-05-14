package _15_数学._633_平方数之和_中等;

public class Solution {
    /**
     * 利用双指针判断是否存在,
     * 设a为最小值, b为最大值, b可取c的平方, 因为c=a^2+b^2
     *
     */

    public boolean judgeSquareSum(int c) {
        int a = 0;
        int b = (int) Math.sqrt(c);
        while (a <= b) {
            int sum = a * a + b * b;
            if (sum == c) {
                return true;
            } else if (sum > c){
                b--;
            }else {
                a++;
            }
        }
        return false;
    }
}
