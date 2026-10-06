class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0, mismatches = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    mismatches++;
                }
            }
        }
        return open + mismatches;
    }
}