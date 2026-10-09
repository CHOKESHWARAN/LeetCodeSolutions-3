class Solution:
    def simplifyPath(self, path: str) -> str:
        components = path.split("/")
        stack = []
        
        for dir in components:
            if not dir or dir == ".":
                continue
            elif dir == "..":
                if stack:
                    stack.pop()
            else:
                stack.append(dir)
                
        return "/" + "/".join(stack)