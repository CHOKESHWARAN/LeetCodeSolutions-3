
class Solution:
    def earliestFinishTime(self, landStartTime: List[int], landDuration: List[int], waterStartTime: List[int], waterDuration: List[int]) -> int:
        def calc(s1, d1, s2, d2):
            end = min(s + d for s, d in zip(s1, d1))
            return min(max(end, s) + d for s, d in zip(s2, d2))

        return min(
            calc(landStartTime, landDuration, waterStartTime, waterDuration),
            calc(waterStartTime, waterDuration, landStartTime, landDuration)
        )
