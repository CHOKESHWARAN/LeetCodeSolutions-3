from typing import List


class Solution:

    def findSubtreeSizes(self, parent: List[int], s: str) -> List[int]:
        n = len(parent)
        children = [[] for _ in range(n)]
        for i in range(1, n):
            children[parent[i]].append(i)

        new_parent = parent[:]
        last_seen = [-1] * 26

        def dfs_reparent(u: int):
            c_idx = ord(s[u]) - ord("a")
            prev_node = last_seen[c_idx]
            if prev_node != -1:
                new_parent[u] = prev_node

            last_seen[c_idx] = u
            for v in children[u]:
                dfs_reparent(v)
            last_seen[c_idx] = prev_node

        dfs_reparent(0)

        new_children = [[] for _ in range(n)]
        for i in range(1, n):
            new_children[new_parent[i]].append(i)

        ans = [0] * n

        def dfs_size(u: int) -> int:
            size = 1
            for v in new_children[u]:
                size += dfs_size(v)
            ans[u] = size
            return size

        dfs_size(0)
        return ans