class Solution:
    def minSumSquareDiff(self, nums1: list[int], nums2: list[int], k1: int, k2: int) -> int:
        n = len(nums1)
        max_diff = 100000
        count = [0] * (max_diff + 1) 
        for i in range(n):
            diff = abs(nums1[i] - nums2[i])
            count[diff] += 1
            
        left = k1 + k2 
        for i in range(max_diff, 0, -1):
            if count[i] > 0:
                reduce = min(left, count[i])
                count[i] -= reduce
                count[i - 1] += reduce
                left -= reduce
                
                if left == 0:
                    break 
        total_sum = 0
        for i in range(1, max_diff + 1):
            if count[i] > 0:
                total_sum += count[i] * (i * i)
                
        return total_sum