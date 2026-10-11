class Solution:
    def sumOfSquares(self, nums: List[int]) -> int:
        k = 0

        for i in range(len(nums)):
            if len(nums) % (i + 1) == 0:
                k += nums[i] * nums[i]

        return k
