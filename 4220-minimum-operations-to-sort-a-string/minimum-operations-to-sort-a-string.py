class Solution:
    def minOperations(self, s: str) -> int:
        n = len(s)
        if all(s[i] <= s[i + 1] for i in range(n - 1)):
            return 0
        if n == 2:
            return -1

        mn, mx = min(s), max(s)

        if s[0] == mn or s[n - 1] == mx:
            return 1

        mn_count = s.count(mn)
        mx_count = s.count(mx)

        if mx_count == 1 and s[0] == mx and mn_count == 1 and s[n - 1] == mn:
            return 3

        return 2