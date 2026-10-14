class Solution:
    def maxSumOfSquares(self, num: int, sum: int) -> str: 
        if sum > 9 * num or sum < 0:
            return ""
            
        res = []
        for i in range(num): 
            curr = min(9, sum)
            res.append(str(curr))
            sum -= curr 
        if sum > 0:
            return ""
            
        return "".join(res)