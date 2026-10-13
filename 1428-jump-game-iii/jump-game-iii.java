class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
        queue.offer(start);
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (arr[curr] == 0) {
                return true;
            }
            if (visited[curr]) {
                continue;
            }
            visited[curr] = true;
            
            int next1 = curr + arr[curr];
            int next2 = curr - arr[curr];
            
            if (next1 < arr.length && !visited[next1]) {
                queue.offer(next1);
            }
            if (next2 >= 0 && !visited[next2]) {
                queue.offer(next2);
            }
        }
        return false;
    }
}