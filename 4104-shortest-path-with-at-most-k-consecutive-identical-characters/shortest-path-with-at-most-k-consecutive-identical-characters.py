from typing import List
import heapq

class Solution:
    def shortestPath(self, n: int, edges: List[List[int]], labels: str, k: int) -> int: 
        adj = [[] for _ in range(n)]
        for u, v, w in edges:
            adj[u].append((v, w))
            
        
        pq = [(0, 0, 1)]
        dist = {}
        
        while pq:
            d, u, count = heapq.heappop(pq)
            
            if u == n - 1:
                return d
                
            if (u, count) in dist and dist[(u, count)] < d:
                continue
            dist[(u, count)] = d
            
            for v, w in adj[u]:
                next_count = count + 1 if labels[u] == labels[v] else 1
                if next_count <= k:
                    next_d = d + w
                    if (v, next_count) not in dist or next_d < dist[(v, next_count)]:
                        dist[(v, next_count)] = next_d
                        heapq.heappush(pq, (next_d, v, next_count))
                        
        return -1