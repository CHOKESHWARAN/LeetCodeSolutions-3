class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length, zero = 0;

        for (int i = 0; i < n; i++)
            if (nums[i] == 0) zero = i;

        int ans = Integer.MAX_VALUE;

        for (int s : new int[]{1, -1}) {
            boolean ok = true;

            for (int i = 1; i < n; i++) {
                int a = (zero + (i - 1) * s + n) % n;
                int b = (zero + i * s + n) % n;

                if (nums[a] > nums[b]) {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                if (s == 1) {
                    ans = Math.min(ans, Math.min(zero, n - zero + 2));
                } else {
                    ans = Math.min(ans, Math.min(zero + 2, n - zero));
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}