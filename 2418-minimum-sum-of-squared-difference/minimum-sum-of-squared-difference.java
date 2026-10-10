class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int maxDiff = 100000;
        long[] count = new long[maxDiff + 1]; 
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            count[diff]++;
        }
        
        long left = (long) k1 + k2; 
        for (int i = maxDiff; i > 0; i--) {
            if (count[i] > 0) {
                long reduce = Math.min(left, count[i]);
                count[i] -= reduce;
                count[i - 1] += reduce;
                left -= reduce;
                
                if (left == 0) break;
            }
        } 
        long totalSum = 0;
        for (int i = 1; i <= maxDiff; i++) {
            if (count[i] > 0) {
                totalSum += count[i] * ((long) i * i);
            }
        }
        
        return totalSum;
    }
}