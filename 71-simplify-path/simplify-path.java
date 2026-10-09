class Solution {
    public String simplifyPath(String path) {
        String[] components = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        
        for (String dir : components) {
            if (dir.isEmpty() || dir.equals(".")) {
                continue;
            } else if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(dir);
            }
        }
        
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append("/").append(stack.pollLast());
        }
        
        return result.length() == 0 ? "/" : result.toString();
    }
}