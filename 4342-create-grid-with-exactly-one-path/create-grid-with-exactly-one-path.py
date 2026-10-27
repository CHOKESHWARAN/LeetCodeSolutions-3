from typing import List

class Solution:
    def createGrid(self, m: int, n: int) -> List[str]:
        g = [['#'] * n for _ in range(m)]
        for i in range(m):
            g[i][n-1] = '.'
        for j in range(n):
            g[0][j] = '.'
        for i in range(1, m):
            g[i][n-1] = '.'
        for i in range(1, m):
            for j in range(n-1):
                g[i][j] = '#'
        return [''.join(row) for row in g]