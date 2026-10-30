import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) { 
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj[u].add(new int[]{v, w});
        } 
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0, 1});  
        
        
        Map<String, Long> visited = new HashMap<>();
        
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            int u = (int) curr[1];
            int count = (int) curr[2];
            
            if (u == n - 1) {
                return (int) d;
            }
            
            String stateKey = u + "," + count;
            if (visited.containsKey(stateKey) && visited.get(stateKey) < d) {
                continue;
            }
            
            for (int[] neighbor : adj[u]) {
                int v = neighbor[0];
                int w = neighbor[1];
                
                int nextCount = (labels.charAt(u) == labels.charAt(v)) ? count + 1 : 1;
                if (nextCount <= k) {
                    long nextDist = d + w;
                    String nextStateKey = v + "," + nextCount;
                    
                    if (!visited.containsKey(nextStateKey) || nextDist < visited.get(nextStateKey)) {
                        visited.put(nextStateKey, nextDist);
                        pq.offer(new long[]{nextDist, v, nextCount});
                    }
                }
            }
        }
        
        return -1;
    }
}