class Solution:
    def minOperations(self, nums: List[int]) -> int:
        n = len(nums)
        z = nums.index(0)

        def check(s):
            return all(nums[(z+i*s) % n] <= nums[(z+(i+1)*s) % n]
                       for i in range(n-1))

        ans = []
        if check(1):
            ans += [z, n-z+2]
        if check(-1):
            ans += [z+2, n-z]

        return min(ans) if ans else -1