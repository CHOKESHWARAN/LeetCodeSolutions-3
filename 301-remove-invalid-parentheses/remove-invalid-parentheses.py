class Solution:
    def removeInvalidParentheses(self, s: str) -> list[str]:
        def isValid(str_val):
            count = 0
            for char in str_val:
                if char == '(':
                    count += 1
                elif char == ')':
                    count -= 1
                    if count < 0:
                        return False
            return count == 0

        res = []
        if not s:
            return [""]
        
        visited = set()
        queue = [s]
        visited.add(s)
        found = False

        while queue:
            curr = queue.pop(0)
            if isValid(curr):
                res.append(curr)
                found = True
            
            if found:
                continue
            
            for i in range(len(curr)):
                if curr[i] != '(' and curr[i] != ')':
                    continue
                next_str = curr[:i] + curr[i+1:]
                if next_str not in visited:
                    visited.add(next_str)
                    queue.append(next_str)
                    
        return res