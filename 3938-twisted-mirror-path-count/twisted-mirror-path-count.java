class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1_000_000_007; 
        int[][][] dp = new int[m][n][2]; 
        
        long[][][] ways = new long[m][n][2]; 

        int[][][] nextPos = new int[m][n][2];  
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) { 
                int curr_r = r, curr_c = c + 1;
                int d = 0;  
                boolean valid = true;
                
                while (curr_r >= 0 && curr_r < m && curr_c >= 0 && curr_c < n && grid[curr_r][curr_c] == 1) {
                    if (d == 0) { 
                        d = 1;
                        curr_r += 1;
                    } else { 
                        d = 0;
                        curr_c += 1;
                    }
                }
                
                if (curr_r < 0 || curr_r >= m || curr_c < 0 || curr_c >= n) {
                    nextPos[r][c][0] = -1;  
                } else {
                    nextPos[r][c][0] = curr_r * n + curr_c;
                }
 
                curr_r = r + 1;
                curr_c = c;
                d = 1;
                
                while (curr_r >= 0 && curr_r < m && curr_c >= 0 && curr_c < n && grid[curr_r][curr_c] == 1) {
                    if (d == 0) {
                        d = 1;
                        curr_r += 1;
                    } else {
                        d = 0;
                        curr_c += 1;
                    }
                }
                
                if (curr_r < 0 || curr_r >= m || curr_c < 0 || curr_c >= n) {
                    nextPos[r][c][1] = -1;
                } else {
                    nextPos[r][c][1] = curr_r * n + curr_c;
                }
            }
        } 
        long[][] dpR = new long[m][n];
        long[][] dpD = new long[m][n];
 
        
        long[][] totalWays = new long[m][n];
        totalWays[0][0] = 1; 
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (totalWays[r][c] == 0) continue;
                 
                int targetR = nextPos[r][c][0] / n;
                int targetC = nextPos[r][c][0] % n;
                if (nextPos[r][c][0] != -1) {
                    totalWays[targetR][targetC] = (totalWays[targetR][targetC] + totalWays[r][c]) % MOD;
                } 
                int targetRD = nextPos[r][c][1] / n;
                int targetCD = nextPos[r][c][1] % n;
                if (nextPos[r][c][1] != -1) {
                    totalWays[targetRD][targetCD] = (totalWays[targetRD][targetCD] + totalWays[r][c]) % MOD;
                }
            }
        }

        return (int) totalWays[m - 1][n - 1];
    }
}