package _14_动态规划._200_岛屿数量_中等;

import java.util.Stack;

public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        // if (grid == null || grid.length == 0) return count;
        int colLen = grid.length;// 行
        int rowLen = grid[0].length; // 列
        for (int col = 0; col < colLen; col++) {
            for (int row = 0; row < rowLen; row++) {
                if (grid[col][row] == '1') {
                    count++;
                    dfs(grid, col, row, colLen, rowLen);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int col, int row, int colLen, int rowLen) {
        if (col < 0 || col >= colLen || row < 0 || row >= rowLen || grid[col][row] == '0') return;

        grid[col][row] = '0';
        dfs(grid, col - 1, colLen, row, rowLen); // 上
        dfs(grid, col + 1, colLen, row, rowLen);// 下
        dfs(grid, col, colLen, row - 1, rowLen);// 左
        dfs(grid, col, colLen, row + 1, rowLen);// 右
    }
}
