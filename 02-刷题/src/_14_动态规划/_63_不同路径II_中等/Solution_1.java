package _14_动态规划._63_不同路径II_中等;

public class Solution_1 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 状态容器
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        // 初始化
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                // 遇到障碍物, 跳出, 后面的也无法走通了
                break;
            }
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                // 遇到障碍物, 跳出, 后面的也无法走通了
                break;
            }
            dp[0][j] = 1;
        }
        // 状态方程
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    // 遇到障碍了
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        // 获得结果
        return dp[m - 1][n - 1];
    }
}
