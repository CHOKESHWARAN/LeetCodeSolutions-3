class Solution {
    public String[] createGrid(int m, int n) {
        String[] g = new String[m];

        for (int i = 0; i < m; i++) {
            char[] row = new char[n];
            java.util.Arrays.fill(row, '#');

            if (i == 0) {
                java.util.Arrays.fill(row, '.');
            } else {
                row[n - 1] = '.';
            }

            g[i] = new String(row);
        }

        return g;
    }
}