class Solution {
    public int closedIsland(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        int count = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 0) {
                    if (dfs(grid, r, c, R, C)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean dfs(int[][] grid, int r, int c, int R, int C) {
        if (r < 0 || r >= R || c < 0 || c >= C) {
            return false;
        }
        if (grid[r][c] == 1) {
            return true;
        }
        grid[r][c] = 1;
        boolean up = dfs(grid, r - 1, c, R, C);
        boolean down = dfs(grid, r + 1, c, R, C);
        boolean left = dfs(grid, r, c - 1, R, C);
        boolean right = dfs(grid, r, c + 1, R, C);
        return up && down && left && right;
    }
}