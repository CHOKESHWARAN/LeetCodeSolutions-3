class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] sq = new long[n];
        for (int i = 0; i < n; i++) {
            long val = nums[i];
            sq[i] = val * val;
        }
        java.util.Arrays.sort(sq);
        long total = 0;
        int mid = n / 2;
        for (int i = 0; i < mid; i++) {
            total -= sq[i];
        }
        for (int i = mid; i < n; i++) {
            total += sq[i];
        }
        return total;
    }
}