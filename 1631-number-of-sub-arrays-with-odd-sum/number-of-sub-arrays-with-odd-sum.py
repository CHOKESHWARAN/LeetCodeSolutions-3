class Solution:

    def numOfSubarrays(self, arr: list[int]) -> int:
        odd_count, even_count = 0, 1
        prefix_sum = 0
        total_odd_subarrays = 0
        MOD = 1_000_000_007

        for num in arr:
            prefix_sum += num
            if prefix_sum % 2 == 1:
                total_odd_subarrays = (
                    total_odd_subarrays + even_count
                ) % MOD
                odd_count += 1
            else:
                total_odd_subarrays = (total_odd_subarrays + odd_count) % MOD
                even_count += 1

        return total_odd_subarrays